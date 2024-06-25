package com.example.myorbitel.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myorbitel.databinding.ItemServiceBinding
import com.example.myorbitel.models.Service

class ServiceTariffAdapter(
    private var services: List<Service>,
    private val onAddService: (Int) -> Unit,
) : RecyclerView.Adapter<ServiceTariffAdapter.ServiceTariffViewHolder>() {
    inner class ServiceTariffViewHolder(val binding: ItemServiceBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(service: Service) {
            "Название:${service.service_name}".also { binding.serviceName.text = it }
            "Описание:${service.feature}".also { binding.serviceFeature.text = it }
            "Цена:${service.price}₽".also { binding.servicePrice.text = it }
            binding.btnAddService.setOnClickListener {
                onAddService(service.service_id)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ServiceTariffViewHolder {
        val binding = ItemServiceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ServiceTariffViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ServiceTariffViewHolder,
        position: Int,
    ) {
        holder.bind(services[position])
    }

    override fun getItemCount(): Int = services.size

    fun updateServices(newServices: List<Service>) {
        services = newServices
        notifyDataSetChanged()
    }
}
