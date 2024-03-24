package com.example.myorbitel.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContentProviderCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.myorbitel.R
import com.example.myorbitel.data.retrofit.TariffsApi
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        /*
        val tv = view.findViewById<TextView>(R.id.tv_tariff)

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
        val lifecycleOwner = viewLifecycleOwner
        val retrofit = Retrofit.Builder()
            .baseUrl("https://f4f1-89-31-37-128.ngrok-free.app/api/v1/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val tariffsApi = retrofit.create(TariffsApi::class.java)

        viewLifecycleOwner.lifecycleScope.launch {
            try {
                val tariffs = tariffsApi.getTariffById(1)
                Log.d("MyFragment", "Попытка получить тариф из сети")

                if (tariffs.isNotEmpty()) {
                    val tariff = tariffs[0] // Предполагается, что возвращается только один тариф
                    Log.d("MyFragment", "Тариф успешно получен: ${tariff.tariff_name}")
                    tv.text = tariff.tariff_name
                } else {
                    Log.e("MyFragment", "Получен пустой список тарифов")
                }
            } catch (e: Exception) {
                // Обработка ошибок
                val text = "ошибка сервера"

                Log.e("MyFragment", "Ошибка при получении тарифа: ${e.message}")
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