package com.example.myorbitel.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myorbitel.databinding.ItemContractBinding
import com.example.myorbitel.models.ContractInfo

class ContractsAdapter(private val contracts: List<ContractInfo>) :
    RecyclerView.Adapter<ContractsAdapter.ContractViewHolder>() {

    inner class ContractViewHolder(val binding: ItemContractBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(contract: ContractInfo) {
            binding.tvContractId.text = "Contract ID: ${contract.id}"
            binding.tvConnectAddress.text = "Address: ${contract.connect_address}"
            binding.tvBalance.text = "Balance: ${contract.balance}"
            binding.tvContractNumber.text = "Number: ${contract.contract_number}"
            binding.tvPersonalAccount.text = "Account: ${contract.personal_account}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContractViewHolder {
        val binding = ItemContractBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContractViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContractViewHolder, position: Int) {
        holder.bind(contracts[position])
    }

    override fun getItemCount(): Int = contracts.size
}
