package com.example.myorbitel.presentation.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myorbitel.R
import com.example.myorbitel.data.retrofit.api.RetrofitBuilder
import okhttp3.logging.HttpLoggingInterceptor


class HomeFragment : Fragment() {


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
        // Inflate the layout for this fragment

       // return inflater.inflate(R.layout.fragment_home, container, false)
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val buttonTopUpBalance = view.findViewById<Button>(R.id.btnTopUpBalance)

        buttonTopUpBalance.setOnClickListener {
            findNavController().navigate(R.id.topUpBalanceFrag)
        }
        return view

    }




}