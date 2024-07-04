package com.example.myorbitel.presentation.fragments.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.myorbitel.R
import com.example.myorbitel.databinding.FragmentLoginBinding
import com.example.myorbitel.models.AuthRequest
import com.example.myorbitel.viewmodels.AuthViewModel

class LoginFragment : Fragment() {
    private lateinit var viewModel: AuthViewModel

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[AuthViewModel::class.java]

        binding.loginBtn.setOnClickListener {
            val phone = binding.personalAccountET.text.toString()
            val password = binding.passwordEt.text.toString()
            viewModel.login(AuthRequest(phone, password))
        }

        viewModel.token.observe(viewLifecycleOwner) {
            it?.let {
                findNavController().navigate(R.id.action_loginFragment_to_clientInfoFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
