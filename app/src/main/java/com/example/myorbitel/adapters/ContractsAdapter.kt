package com.example.myorbitel.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myorbitel.databinding.ItemContractBinding
import com.example.myorbitel.models.ContractInfo

class ContractsAdapter(private val contracts: List<ContractInfo>, private val onContractClick: (Int) -> Unit) :
    RecyclerView.Adapter<ContractsAdapter.ContractViewHolder>() {
    inner class ContractViewHolder(val binding: ItemContractBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(contract: ContractInfo) {
            "Адрес подключения: ${contract.connect_address}".also { binding.tvConnectAddress.text = it }
            "Текущий баланс: ${contract.balance} ₽".also { binding.tvBalance.text = it }
            "Номер договора: ${contract.contract_number}".also { binding.tvContractNumber.text = it }
            "Лицевой счёт: ${contract.personal_account}".also { binding.tvPersonalAccount.text = it }
            binding.root.setOnClickListener {
                onContractClick(contract.contract_id)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ContractViewHolder {
        val binding = ItemContractBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContractViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ContractViewHolder,
        position: Int,
    ) {
        holder.bind(contracts[position])
    }

    override fun getItemCount(): Int = contracts.size
}
