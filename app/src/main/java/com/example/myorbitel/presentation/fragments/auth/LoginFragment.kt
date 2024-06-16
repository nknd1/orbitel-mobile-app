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

/*
class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private val viewModel: LoginViewModel by viewModels()

    val TAG = "Login"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)


        binding.loginBtn.setOnClickListener {
            val client_phone = binding.personalAccountET.text.toString()
            val password = binding.passwordEt.text.toString()

            lifecycleScope.launch {
                val authRequest = AuthRequest(client_phone, password)
                viewModel.login(authRequest).observe(viewLifecycleOwner) { result ->
                    when(result){
                        is LoginResult.Success -> {
                            Log.d(TAG, "onCreateView: ")
                            val token = result.token

                        }
                        is LoginResult.Error ->
                            Log.d(TAG, "onCreateView: d")


                    }
                }
            }

        }



        return binding.root



    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

 */

class LoginFragment : Fragment() {
    private lateinit var viewModel: AuthViewModel

    @Suppress("ktlint:standard:backing-property-naming")
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
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
            binding.personalAccountET.setText("+7")

            binding.personalAccountET.text?.let { it1 -> binding.personalAccountET.setSelection(it1.length) }
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
