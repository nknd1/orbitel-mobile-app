package com.example.myorbitel.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myorbitel.R


import com.example.myorbitel.models.Tariffs
/*
class TariffsAdapter: ListAdapter<Tariffs, TariffsAdapter.Holder>(Comparator()) {
    class Holder(view: View) : RecyclerView.ViewHolder(view){
        private val binding = ListItemBinding.bind(view)

        fun bind(tariffs: Tariffs) = with(binding){
            tvTariffName.text = tariffs.tariff_name
            tvPricePerMonthForTariff.text = tariffs.price_per_month
            tvInternetSpeed.text = tariffs.speed
        }
    }

    class Comparator : DiffUtil.ItemCallback<Tariffs>(){
        override fun areItemsTheSame(oldItem: Tariffs, newItem: Tariffs): Boolean {
           return oldItem.tariff_id == newItem.tariff_id
        }

        override fun areContentsTheSame(oldItem: Tariffs, newItem: Tariffs): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }

}

 */
