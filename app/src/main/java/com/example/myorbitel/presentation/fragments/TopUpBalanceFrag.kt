package com.example.myorbitel.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.myorbitel.R
import com.example.myorbitel.databinding.FragmentTopUpBalanceBinding
import com.example.myorbitel.models.TopUpRequest
import com.example.myorbitel.models.TopUpResponse
import com.example.myorbitel.utils.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class TopUpBalanceFrag : Fragment() {
    private var _binding: FragmentTopUpBalanceBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentTopUpBalanceBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonTopUp.setOnClickListener {
            val contractId = binding.editTextContractId.text.toString().toIntOrNull()
            val balance = binding.editTextBalance.text.toString().toIntOrNull()

            if (contractId != null && balance != null) {
                showLoading(true)
                topUpBalance(contractId, balance)
            } else {
                Toast.makeText(context, "Please enter valid contract ID and balance", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun topUpBalance(contractId: Int, balance: Int) {
        val request = TopUpRequest(contractId, balance)
        RetrofitInstance.api_v1.topUpBalance(request).enqueue(object : Callback<TopUpResponse> {
            override fun onResponse(call: Call<TopUpResponse>, response: Response<TopUpResponse>) {
                showLoading(false)
                if (response.isSuccessful) {
                    response.body()?.let {
                        Toast.makeText(context, it.message, Toast.LENGTH_LONG).show()
                    }
                } else {
                    Toast.makeText(context, "Failed to top up balance", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<TopUpResponse>, t: Throwable) {
                showLoading(false)
                Toast.makeText(context, "Error: ${t.message}", Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun showLoading(isLoading: Boolean) {
        if (isLoading) {
            binding.progressBar.visibility = View.VISIBLE
            binding.buttonTopUp.isEnabled = false
            binding.buttonTopUp.text = ""
        } else {
            binding.progressBar.visibility = View.GONE
            binding.buttonTopUp.isEnabled = true
            binding.buttonTopUp.setText(R.string.top_up)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}