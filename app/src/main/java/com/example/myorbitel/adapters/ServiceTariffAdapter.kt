package com.example.myorbitel.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myorbitel.databinding.ItemSerBinding
import com.example.myorbitel.models.Service

class ServiceTariffAdapter(
    private val services: List<Service>
) : RecyclerView.Adapter<ServiceTariffAdapter.ServiceViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder {
        val binding = ItemSerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ServiceViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ServiceViewHolder, position: Int) {
        val service = services[position]
        holder.bind(service)
    }

    override fun getItemCount(): Int = services.size

    inner class ServiceViewHolder(private val binding: ItemSerBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(service: Service) {
            binding.serviceName.text = service.service_name
            binding.serviceFeature.text = service.feature
            binding.servicePrice.text = service.price
        }
    }
}