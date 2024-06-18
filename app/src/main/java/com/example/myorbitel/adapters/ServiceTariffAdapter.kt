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
            binding.serviceName.text = service.service_name
            binding.serviceFeature.text = service.feature
            binding.servicePrice.text = "${service.price}₽"
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
