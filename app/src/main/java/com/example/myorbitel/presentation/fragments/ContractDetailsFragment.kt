package com.example.myorbitel.presentation.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myorbitel.R
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
                "ID: ${contractInfoResponse.contractDetails.contract_id}".also { binding.tvContractId.text = it }
                binding.tvTariffName.text = contractInfoResponse.contractDetails.tariff_name
                "Цена: ${contractInfoResponse.contractDetails.tariff_price}₽ в месяц".also { binding.tvTariffPrice.text = it }
                "Скорость интернета: ${contractInfoResponse.contractDetails.speed} мбит/с".also { binding.tvTariffSpeed.text = it }

                val serviceAdapter =
                    ServiceAdapter(contractInfoResponse.services) { serviceId ->
                        viewModel.removeServiceFromContract(contractId, serviceId)
                    }
                binding.recyclerViewServices.adapter = serviceAdapter
                binding.recyclerViewServices.layoutManager = LinearLayoutManager(requireContext())
            }
        }

        viewModel.serviceRemoved.observe(viewLifecycleOwner) { removed ->
            if (removed) {
                Toast.makeText(requireContext(), "Услуга успешно удалена", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Не удалось удалить услугу", Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.getContractDetails(contractId)

        binding.btnManageServices.setOnClickListener {
            val bundle =
                Bundle().apply {
                    putString("contractId", contractId)
                }
            findNavController().navigate(R.id.action_contractDetailsFragment_to_serviceListFragment, bundle)
        }
    }
}
