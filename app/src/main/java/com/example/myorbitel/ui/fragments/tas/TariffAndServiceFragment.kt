package com.example.myorbitel.ui.fragments.tas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myorbitel.R

/**
 * A simple [Fragment] subclass.
 * Use the [TariffAndServiceFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TariffAndServiceFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            var ARG_PARAM1 = null
            param1 = it.getString(ARG_PARAM1)
            var ARG_PARAM2 = null
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tariff_and_service, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TariffAndServiceFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TariffAndServiceFragment().apply {
                arguments = Bundle().apply {
                    var ARG_PARAM1 = null
                    putString(ARG_PARAM1, param1)
                    var ARG_PARAM2 = null
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}