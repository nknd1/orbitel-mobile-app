package com.example.myorbitel.presentation.fragments.auth

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.myorbitel.R
import com.example.myorbitel.databinding.FragmentLoginBinding
import com.example.myorbitel.viewmodels.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint


class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    /*
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

     */

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentLoginBinding.inflate(inflater, container, false)


        binding.loginBtn.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
        }
        return binding.root
        //return inflater.inflate(R.layout.fragment_login, container, false)

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    /*
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        val loginBtn = view.findViewById<Button>(R.id.loginBtn)

        loginBtn.setOnClickListener {
                viewModel.navigateToHomeFrag()
        }
        viewModel.navigateToHomeFrag.observe(viewLifecycleOwner) { navigate ->
            if (navigate) {
                findNavController().navigate(R.id.homeFragment)

            }
        }


    }



     */

}