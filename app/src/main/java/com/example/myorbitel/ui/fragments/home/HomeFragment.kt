package com.example.myorbitel.ui.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myorbitel.R
import com.example.myorbitel.data.retrofit.api.RetrofitBuilder


class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val retrofitBuilder = RetrofitBuilder.contractInfoApi
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
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        private const val ARG_PARAM1 = "param1"
        private const val ARG_PARAM2 = "param2"

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}