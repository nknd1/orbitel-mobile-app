package com.example.myorbitel.presentation.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.myorbitel.R
import com.example.myorbitel.data.retrofit.api.ContractInfoApi
import com.example.myorbitel.databinding.FragmentHomeBinding
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
   // private val TAG: String = "AppDebug"
   private lateinit var loadingText: String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)


        setLoadingText()

        binding.btnTopUpBalance.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_topUpBalanceFrag)
        }



        binding.btnProfile.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_profileFragment)
        }

        binding.materialCardViewTariffsList.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_tariffListFragment3)
        }


        binding.materialCardViewvsfs.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_transactionHistoryFragment)
        }


        binding.materialCardViewServiceList.setOnClickListener{
                findNavController().navigate(R.id.action_homeFragment_to_serviceListFragment2)
        }

        binding.materialCardViewMyTariff.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_tariffDetailsFragment)
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
                val contractInfo = contractInfoApi.getContractInfo(22)
                Timber.tag("MyFragment").d("Попытка получить договор из сети")

                if (contractInfo.isNotEmpty()) {
                    val contract =
                        contractInfo[0] // Предполагается, что возвращается только один договор
                    Timber.tag("MyFragment")
                        .d("Информация о договоре успешно получена: %s", contract.contract_number)

                    "Лицевой счёт: ${contract.personal_account}".also { binding.tvPersonalAccount.text= it }
                    "Адрес подключения: ${contract.connect_address}".also { binding.tvConnectAddress.text= it }
                    binding.tvBalanceInfo.text = contract.balance
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
    }

    private fun setLoadingText() {
        loadingText = getString(R.string.loading_text)
        binding.tvBalanceInfo.text = loadingText
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }




}