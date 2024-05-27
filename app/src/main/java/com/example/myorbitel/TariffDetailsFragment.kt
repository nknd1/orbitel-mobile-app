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
import com.example.myorbitel.adapters.ServiceTariffAdapter
import com.example.myorbitel.databinding.FragmentTariffDetailsBinding
import com.example.myorbitel.viewmodels.TariffViewModel

class TariffDetailsFragment : Fragment() {

    private var _binding: FragmentTariffDetailsBinding? = null
    private val binding get() = _binding!!
    private lateinit var serviceTariffAdapter: ServiceTariffAdapter
    private lateinit var viewModel: TariffViewModel
    private var tariffId: Int = 1 // Assign this value as needed

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTariffDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        viewModel = ViewModelProvider(this)[TariffViewModel::class.java]

        viewModel.tariffDetails.observe(viewLifecycleOwner, Observer { details ->
            details?.let { it ->
                binding.tariffName.text = it.tariff.tariff_name
                "Price: ${it.tariff.price_per_month}".also { binding.tariffPrice.text = it }
                "Speed: ${it.tariff.speed}".also { binding.tariffSpeed.text = it }
                serviceTariffAdapter = ServiceTariffAdapter(it.services)
                binding.recyclerView.adapter = serviceTariffAdapter
                binding.recyclerView.visibility = View.VISIBLE
                binding.progressBar.visibility = View.GONE
            }
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

        viewModel.fetchTariffDetails(tariffId)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}