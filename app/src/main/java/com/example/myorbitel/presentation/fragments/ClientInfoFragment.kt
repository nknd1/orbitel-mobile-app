package com.example.myorbitel.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myorbitel.adapters.ContractsAdapter
import com.example.myorbitel.databinding.FragmentClientInfoBinding
import com.example.myorbitel.viewmodels.AuthViewModel

class ClientInfoFragment : Fragment() {
    private lateinit var viewModel: AuthViewModel
    private var _binding: FragmentClientInfoBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: ContractsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentClientInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[AuthViewModel::class.java]
        setupRecyclerView()
        viewModel.getClientInfo()
        viewModel.getContracts()

        viewModel.clientInfo.observe(viewLifecycleOwner) { clientInfo ->
            clientInfo?.let {
                binding.tvClientAddressRegistration.text = "Адрес регистрации: ${it.client_address_registration}"
                binding.tvClientFio.text = "ФИО: ${it.client_fio}"
                binding.tvClientPhone.text = "Номер телефона: ${it.client_phone}"
                binding.tvTypeId.text = "Тип клиента: ${it.client_type}"
            }
        }
        viewModel.contracts.observe(viewLifecycleOwner) { contracts ->
            contracts?.let {
                adapter =
                    ContractsAdapter(contracts) { contractId ->
                        val action = ClientInfoFragmentDirections.actionClientInfoFragmentToContractDetailsFragment(contractId)
                        findNavController().navigate(action)
                    }
                binding.recyclerViewContracts.adapter = adapter
            }
        }
    }

    private fun setupRecyclerView() {
        binding.recyclerViewContracts.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
