package com.example.myorbitel.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myorbitel.R
import com.example.myorbitel.adapters.ContractsAdapter
import com.example.myorbitel.databinding.FragmentClientInfoBinding
import com.example.myorbitel.viewmodels.AuthViewModel

class ClientInfoFragment : Fragment() {

    private lateinit var viewModel: AuthViewModel
    private var _binding: FragmentClientInfoBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: ContractsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentClientInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(AuthViewModel::class.java)
        setupRecyclerView()
        viewModel.getClientInfo()
        viewModel.getContracts()

        viewModel.clientInfo.observe(viewLifecycleOwner) { clientInfo ->
            clientInfo?.let {
                binding.tvClientId.text = "ID: ${it.client_id}"
                binding.tvClientAddressRegistration.text = "Адрес регистрации: ${it.client_address_registration}"
                binding.tvClientFio.text = "фио: ${it.client_fio}"
                binding.tvClientPhone.text = "Номер телефона: ${it.client_phone}"
                binding.tvTypeId.text = "Тип клиента: ${it.client_type}"
            }
        }
        viewModel.contracts.observe(viewLifecycleOwner) { contracts ->
            contracts?.let {
                adapter = ContractsAdapter(it)
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

