package com.example.myorbitel.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myorbitel.models.Transaction
import com.example.myorbitel.utils.RetrofitInstance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TransactionViewModel : ViewModel() {
    private val _transactions = MutableLiveData<List<Transaction>>()
    val transactions: LiveData<List<Transaction>> get() = _transactions

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> get() = _loading

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    fun fetchTransactions() {
        _loading.value = true
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val writeOffs = RetrofitInstance.api_v1.getWriteOffs()
                val deposits = RetrofitInstance.api_v1.getDeposits()

                val transactions = mutableListOf<Transaction>()
                transactions.addAll(writeOffs.map { Transaction.WriteOffTransaction(it) })
                transactions.addAll(deposits.map { Transaction.DepositTransaction(it) })

                withContext(Dispatchers.Main) {
                    _transactions.value = transactions
                    _loading.value = false
                }
            } catch (e: Exception) {
                e.printStackTrace()
                withContext(Dispatchers.Main) {
                    _error.value = "Error: ${e.message}"
                    _loading.value = false
                }
            }
        }
    }
}
