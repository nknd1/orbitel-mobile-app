package com.example.myorbitel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myorbitel.adapters.TariffAdapter
import com.example.myorbitel.databinding.FragmentTariffListfBinding
import com.example.myorbitel.utils.RetrofitInstance
import com.example.myorbitel.viewmodels.TariffViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TariffListFragment : Fragment() {

    private var _binding: FragmentTariffListfBinding? = null
    private val binding get() = _binding!!
    private lateinit var tariffAdapter: TariffAdapter
    private lateinit var viewModel: TariffViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTariffListfBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        viewModel = ViewModelProvider(this)[TariffViewModel::class.java]


        viewModel.tariffs.observe(viewLifecycleOwner, Observer { tariffs ->
            tariffAdapter = TariffAdapter(tariffs)
            binding.recyclerView.adapter = tariffAdapter
        })

        viewModel.loading.observe(viewLifecycleOwner, Observer { isLoading ->
            binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
            binding.recyclerView.visibility = if (isLoading) View.GONE else View.VISIBLE
        })

        viewModel.error.observe(viewLifecycleOwner, Observer { errorMessage ->
            errorMessage?.let {
                Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
            }
        })

        viewModel.fetchTariffs()
    }


    /*
    private fun fetchTariffs() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = RetrofitInstance.api.getAllTariffs()
                withContext(Dispatchers.Main) {
                    tariffAdapter = TariffAdapter(response)
                    binding.recyclerView.adapter = tariffAdapter
                }
            } catch (e: Exception) {
                e.printStackTrace()
                // Handle the error appropriately
                withContext(Dispatchers.Main) {
                    Toast.makeText(requireContext(), "Error: ${e.message}", Toast.LENGTH_LONG).show()
                }
            }
        }
    }


     */
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
