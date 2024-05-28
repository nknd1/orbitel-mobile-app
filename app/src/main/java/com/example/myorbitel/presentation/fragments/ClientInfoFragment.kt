package com.example.myorbitel.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.myorbitel.R
import com.example.myorbitel.databinding.FragmentClientInfoBinding
import com.example.myorbitel.viewmodels.AuthViewModel

class ClientInfoFragment : Fragment() {

    private lateinit var viewModel: AuthViewModel
    private var _binding: FragmentClientInfoBinding? = null
    private val binding get() = _binding!!

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

        viewModel.getClientInfo()

        viewModel.clientInfo.observe(viewLifecycleOwner) { clientInfo ->
            clientInfo?.let {
                binding.tvBalance.text = "Balance: ${it.balance}"
                binding.tvClientAddressRegistration.text = "Client Address Registration: ${it.client_address_registration}"
                binding.tvClientFio.text = "Client FIO: ${it.client_fio}"
                binding.tvClientId.text = "Client ID: ${it.client_id}"
                binding.tvClientPhone.text = "Client Phone: ${it.client_phone}"
                binding.tvConnectAddress.text = "Connect Address: ${it.connect_address}"
                binding.tvContractClientId.text = "Contract Client ID: ${it.contract_client_id}"
                binding.tvContractId.text = "Contract ID: ${it.contract_id}"
                binding.tvContractNumber.text = "Contract Number: ${it.contract_number}"
                binding.tvCreatedAt.text = "Created At: ${it.created_at}"
                binding.tvPassword.text = "Password: ${it.password}"
                binding.tvPersonalAccount.text = "Personal Account: ${it.personal_account}"
                binding.tvTypeId.text = "Type ID: ${it.type_id}"
                binding.tvUpdatedAt.text = "Updated At: ${it.updated_at}"
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

