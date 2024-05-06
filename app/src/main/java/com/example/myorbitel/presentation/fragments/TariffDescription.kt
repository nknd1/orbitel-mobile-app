package com.example.myorbitel.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myorbitel.R
import com.example.myorbitel.databinding.FragmentHistoryOperationBinding
import com.example.myorbitel.databinding.FragmentTariffDescriptionBinding


class TariffDescription : Fragment() {
    private var _binding: FragmentTariffDescriptionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTariffDescriptionBinding.inflate(inflater, container, false)
        //return inflater.inflate(R.layout.fragment_history_operation, container, false)

        binding.btnBackTo.setOnClickListener {
            findNavController().navigate(R.id.action_tariffDescription_to_homeFragment)
        }
        return binding.root
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}