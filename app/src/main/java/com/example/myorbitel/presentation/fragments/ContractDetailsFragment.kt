package com.example.myorbitel.presentation.fragments

import android.annotation.SuppressLint
import android.os.Bundle
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

        viewModel.contractDetails.observe(viewLifecycleOwner) { contractInfoResponse ->
            contractInfoResponse?.let {
                binding.tvContractId.text = contractInfoResponse.contractDetails.contract_id
                binding.tvTariffName.text = contractInfoResponse.contractDetails.tariff_name
                binding.tvTariffPrice.text = contractInfoResponse.contractDetails.tariff_price
                binding.tvTariffSpeed.text = contractInfoResponse.contractDetails.speed

                val serviceAdapter = ServiceAdapter(contractInfoResponse.services)
                binding.recyclerViewServices.adapter = serviceAdapter
                binding.recyclerViewServices.layoutManager = LinearLayoutManager(requireContext())
            }
        }
        viewModel.getContractDetails(contractId)
    }
}
