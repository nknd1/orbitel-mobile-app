package com.example.myorbitel.presentation.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myorbitel.adapters.ServiceAdapter
import com.example.myorbitel.databinding.FragmentServiceListBinding
import com.example.myorbitel.viewmodels.ServiceViewModel

class ServiceListFragment : Fragment() {

    private var _binding: FragmentServiceListBinding? = null
    private val binding get() = _binding!!
    private lateinit var serviceAdapter: ServiceAdapter
    private lateinit var viewModel: ServiceViewModel
    private var selectedTariffId: Int = 2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentServiceListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        viewModel = ViewModelProvider(this)[ServiceViewModel::class.java]


        viewModel.services.observe(viewLifecycleOwner, Observer { services ->
            serviceAdapter = ServiceAdapter(services) { service -> viewModel.addServiceToTariff(service.service_id, selectedTariffId) }
            binding.recyclerView.adapter = serviceAdapter
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

        viewModel.addServiceResponse.observe(viewLifecycleOwner, Observer { message ->
            message?.let {
                showSuccessDialog(it)
            }
        })

        viewModel.fetchServices()
    }

    private fun showSuccessDialog(message: String) {
        AlertDialog.Builder(requireContext())
            .setTitle("Успех")
            .setMessage(message)
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
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