package com.example.myorbitel.presentation.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myorbitel.adapters.ServiceAdapter
import com.example.myorbitel.databinding.FragmentContractDetailsBinding
import com.example.myorbitel.viewmodels.ContractDetailsViewModel

class ContractDetailsFragment : Fragment() {
    private lateinit var binding: FragmentContractDetailsBinding
    private lateinit var viewModel: ContractDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentContractDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("LogNotTimber")
    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[ContractDetailsViewModel::class.java]

        val contractId = arguments?.getString("contractId") ?: return

        viewModel.contractDetails.observe(viewLifecycleOwner) { contractDetails ->
            contractDetails?.let {
                Log.d("ContractDetailsFragment", "Contract ID: ${contractDetails.contract_id}")
                Log.d("ContractDetailsFragment", "Tariff Name: ${contractDetails.tariff_name}")
                Log.d("ContractDetailsFragment", "Tariff Price: ${contractDetails.tariff_price}")
                Log.d("ContractDetailsFragment", "Tariff Speed: ${contractDetails.speed}")

                binding.tvContractId.text = it.contract_id
                binding.tvTariffName.text = it.tariff_name
                binding.tvTariffPrice.text = it.tariff_price
                binding.tvTariffSpeed.text = it.speed

                val serviceAdapter = ServiceAdapter(contractDetails.services)
                binding.recyclerViewServices.adapter = serviceAdapter
                binding.recyclerViewServices.layoutManager = LinearLayoutManager(requireContext())
            }
        }
        viewModel.getContractDetails(contractId)
    }
}
