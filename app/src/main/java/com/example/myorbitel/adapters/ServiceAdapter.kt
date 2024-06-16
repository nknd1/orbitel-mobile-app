package com.example.myorbitel.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myorbitel.databinding.ItemSerBinding
import com.example.myorbitel.models.Services

class ServiceAdapter(
    private val services: List<Services>,
) : RecyclerView.Adapter<ServiceAdapter.ServiceViewHolder>() {
    inner class ServiceViewHolder(val binding: ItemSerBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(services: Services) {
            "Название: ${services.service_name}".also { binding.serviceName.text = it }
            "Описание: ${services.feature}".also { binding.serviceFeature.text = it }
            "Стоимость: ${services.price} руб. ".also { binding.servicePrice.text = it }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ServiceViewHolder {
        val binding = ItemSerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ServiceViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ServiceViewHolder,
        position: Int,
    ) {
        holder.bind(services[position])
    }

    override fun getItemCount(): Int {
        return services.size
    }
}
