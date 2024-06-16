package com.example.myorbitel.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myorbitel.databinding.ItemSerBinding
import com.example.myorbitel.models.Service

class ServiceAdapter(
    private val services: List<Service>,
    private val onRemoveService: (Int) -> Unit,
) : RecyclerView.Adapter<ServiceAdapter.ServiceViewHolder>() {
    inner class ServiceViewHolder(val binding: ItemSerBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(services: Service) {
            "Название: ${services.service_name}".also { binding.serviceName.text = it }
            "Описание: ${services.feature}".also { binding.serviceFeature.text = it }
            "Стоимость: ${services.price}₽".also { binding.servicePrice.text = it }
            binding.btnRemoveService.setOnClickListener {
                onRemoveService(services.service_id)
            }
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
