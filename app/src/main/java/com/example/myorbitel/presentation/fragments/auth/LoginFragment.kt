package com.example.myorbitel.presentation.fragments.auth

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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
            if (validateInput(phone, password)) {
                showLoading()
                viewModel.login(AuthRequest(phone, password))
            }
        }

        viewModel.token.observe(viewLifecycleOwner) {
            it?.let {
                hideLoading()
                findNavController().navigate(R.id.action_loginFragment_to_clientInfoFragment)
            }
        }
        viewModel.loginError.observe(viewLifecycleOwner) {
            it?.let {
                hideLoading()
                showError("Неверные данные")
            }
        }
        viewModel.isLoading.observe(viewLifecycleOwner) { isLoading -> if (isLoading) showLoading() else hideLoading() }
    }

    private fun validateInput(
        phone: String,
        password: String,
    ): Boolean {
        var isValid = true

        if (phone.isBlank()) {
            binding.personalAccountET.setBackgroundColor(Color.RED)
            isValid = false
        } else {
            binding.personalAccountET.setBackgroundColor(Color.LTGRAY)
        }
        if (password.isBlank()) {
            binding.passwordEt.setBackgroundColor(Color.RED)
            isValid = true
        } else {
            binding.passwordEt.setBackgroundColor(Color.LTGRAY)
        }
        return isValid
    }

    private fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }

    private fun showLoading() {
        binding.progressBarLogin.visibility = View.VISIBLE
        binding.loginBtn.isEnabled = false
        binding.personalAccountET.isEnabled = false
        binding.passwordEt.isEnabled = false
    }

    private fun hideLoading() {
        binding.progressBarLogin.visibility = View.GONE
        binding.loginBtn.isEnabled = true
        binding.personalAccountET.isEnabled = true
        binding.passwordEt.isEnabled = true
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
