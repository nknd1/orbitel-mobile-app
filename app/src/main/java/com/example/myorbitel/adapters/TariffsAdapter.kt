package com.example.myorbitel.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myorbitel.databinding.ItemTariffBinding
import com.example.myorbitel.models.Tariffs


class TariffAdapter(private val tariffs: List<Tariffs>) : RecyclerView.Adapter<TariffAdapter.TariffViewHolder>() {

    inner class TariffViewHolder(val binding: ItemTariffBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tariffs: Tariffs ){
            "Название: ${tariffs.tariff_name}".also { binding.tariffName.text = it }
            "Цена: ${tariffs.price_per_month}".also { binding.tariffPrice.text = it }
            "Скорость: ${tariffs.speed} Mbps".also { binding.tariffSpeed.text = it }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TariffViewHolder {
        val binding = ItemTariffBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TariffViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TariffViewHolder, position: Int) {
        holder.bind(tariffs[position])
    }

    override fun getItemCount(): Int {
        return tariffs.size
    }
}


