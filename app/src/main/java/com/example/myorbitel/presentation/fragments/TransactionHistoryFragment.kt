package com.example.myorbitel.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myorbitel.R
import com.example.myorbitel.databinding.FragmentHistoryOperationBinding
import com.example.myorbitel.databinding.FragmentHomeBinding


class HistoryOperation : Fragment() {
    private var _binding: FragmentHistoryOperationBinding? = null
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        _binding = FragmentHistoryOperationBinding.inflate(inflater, container, false)
        //return inflater.inflate(R.layout.fragment_history_operation, container, false)
        return binding.root
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}