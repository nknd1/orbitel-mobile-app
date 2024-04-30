package com.example.myorbitel.presentation.fragments.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.myorbitel.R
import com.example.myorbitel.data.retrofit.api.ContractInfoApi
import com.example.myorbitel.databinding.FragmentHomeBinding
import com.example.myorbitel.databinding.FragmentLoginBinding
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        /*
        val tvBalance = view.findViewById<TextView>(R.id.tvBalance)
        val tvContractNumber = view.findViewById<TextView>(R.id.tvContractNumber)
        val tvPersonalAccount = view.findViewById<TextView>(R.id.tvPersonalAccount)

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()



        val retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3001/api/v1/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val contractInfoApi = retrofit.create(ContractInfoApi::class.java)

        viewLifecycleOwner.lifecycleScope.launch {
            try {
                //val tariffs= tariffsApi.getTariffById(1)
                val contractInfo = contractInfoApi.getContractInfo(16)
                Log.d("MyFragment", "Попытка получить договор из сети")

                if (contractInfo.isNotEmpty()) {
                    val contract = contractInfo[0] // Предполагается, что возвращается только один договор
                    Log.d("MyFragment", "Информация о договоре успешно получена: ${contract.contract_number}")
                    tvBalance.text = contract.balance
                    tvContractNumber.text = contract.contract_number
                    tvPersonalAccount.text = contract.personal_account

                } else {
                    Log.e("MyFragment", "Получен пустой список договоров")
                }
            } catch (e: Exception) {
                // Обработка ошибок
                val text = "ошибка сервера"

                Log.e("MyFragment", "Ошибка при получении информации о договоре: ${e.message}")
            }
        }
    }

         */
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.btnTopUpBalance.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_topUpBalanceFrag)
        }

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()


        val retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3001/api/v1/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val contractInfoApi = retrofit.create(ContractInfoApi::class.java)

        viewLifecycleOwner.lifecycleScope.launch {
            try {
                //val tariffs= tariffsApi.getTariffById(1)
                val contractInfo = contractInfoApi.getContractInfo(16)
                Timber.tag("MyFragment").d("Попытка получить договор из сети")

                if (contractInfo.isNotEmpty()) {
                    val contract =
                        contractInfo[0] // Предполагается, что возвращается только один договор
                    Timber.tag("MyFragment")
                        .d("Информация о договоре успешно получена: %s", contract.contract_number)
                    binding.tvBalanceInfo.text = contract.balance
                    binding.tvTariffInfoName.text = contract.tariff_name


                } else {
                    Timber.tag("MyFragment").e("Получен пустой список договоров")
                }
            } catch (e: Exception) {
                // Обработка ошибок
                val text = "ошибка сервера"

                Timber.tag("MyFragment")
                    .e("Ошибка при получении информации о договоре: %s", e.message)
                Timber.tag("ex").e(text)
            }
        }



        return binding.root
        //return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }




}