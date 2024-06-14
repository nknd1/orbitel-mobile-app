package com.example.myorbitel.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myorbitel.databinding.ItemContractBinding
import com.example.myorbitel.models.ContractInfo

class ContractsAdapter(private val contracts: List<ContractInfo>, private val onContractClick: (String) -> Unit) :
    RecyclerView.Adapter<ContractsAdapter.ContractViewHolder>() {
    inner class ContractViewHolder(val binding: ItemContractBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(contract: ContractInfo) {
            binding.tvContractId.text = "ID: ${contract.contract_id}"
            binding.tvConnectAddress.text = "Адрес подключения: ${contract.connect_address}"
            binding.tvBalance.text = "Текущий балнас: ${contract.balance}"
            binding.tvContractNumber.text = "Номер договора: ${contract.contract_number}"
            binding.tvPersonalAccount.text = "Лицевой счёт: ${contract.personal_account}"
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
