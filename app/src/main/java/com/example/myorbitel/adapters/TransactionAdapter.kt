package com.example.myorbitel.adapters
/*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myorbitel.databinding.ItemTransactionBinding
import com.example.myorbitel.models.Transaction

class TransactionAdapter(private val transactions: List<Transaction>) : RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder>() {

    inner class TransactionViewHolder(val binding: ItemTransactionBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(transaction: Transaction) {
            when (transaction) {
                is Transaction.WriteOffTransaction -> {
                    binding.transactionType.text = "Списание"
                    binding.transactionDate.text = transaction.writeoff.date_writeoffs
                    binding.transactionTime.text = transaction.writeoff.time_writeoffs
                    "Сумма -: ${transaction.writeoff.amount}".also { binding.transactionAmount.text = it }
                    binding.transactionReason.apply {
                        visibility = View.VISIBLE
                        "Причина: ${transaction.writeoff.reason}".also { text = it }
                    }
                }
                is Transaction.DepositTransaction -> {
                    binding.transactionType.text = "Пополнение"
                    binding.transactionDate.text = transaction.deposit.date_deposits
                    binding.transactionTime.text = transaction.deposit.time_deposits
                    "Сумма +: ${transaction.deposit.amount}".also { binding.transactionAmount.text = it }
                    binding.transactionReason.visibility = View.GONE
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val binding = ItemTransactionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TransactionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        holder.bind(transactions[position])
    }

    override fun getItemCount(): Int {
        return transactions.size
    }
}

 */
