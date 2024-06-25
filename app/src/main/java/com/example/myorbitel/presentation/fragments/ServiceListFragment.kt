package com.example.myorbitel.presentation.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myorbitel.adapters.ServiceTariffAdapter
import com.example.myorbitel.databinding.FragmentServiceListBinding
import com.example.myorbitel.viewmodels.ServiceListViewModel

class ServiceListFragment : Fragment() {
    private lateinit var binding: FragmentServiceListBinding
    private lateinit var viewModel: ServiceListViewModel
    private lateinit var adapter: ServiceTariffAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentServiceListBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("LogNotTimber")
    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[ServiceListViewModel::class.java]

        adapter =
            ServiceTariffAdapter(emptyList()) { serviceId ->
                val contractId = arguments?.getInt("contractId") ?: return@ServiceTariffAdapter
                viewModel.addServiceToContract(contractId, serviceId)
            }

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter

        viewModel.services.observe(viewLifecycleOwner) { services ->
            Log.d("ServiceListFragment", "Services: $services")
            adapter.updateServices(services)
        }

        viewModel.serviceAdded.observe(viewLifecycleOwner) { serviceAdded ->
            if (serviceAdded) {
                Toast.makeText(requireContext(), "Услуга успешно подключена", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Ошибка при добавлении услуги", Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.loading.observe(viewLifecycleOwner) { isLoading ->
            binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        }
        viewModel.getAllServices()
    }
}
