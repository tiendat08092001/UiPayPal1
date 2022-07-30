package com.example.uipaypal.main

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.uipaypal.data.history_trade.HistoryTradeDataSource

class TradeViewModel(val historyTradeDataSource: HistoryTradeDataSource) : ViewModel() {
    val historyTradeLiveData = historyTradeDataSource.getHistoryTradeList()

}

class TradeViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TradeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TradeViewModel(
                historyTradeDataSource = HistoryTradeDataSource.getUserDataSource()
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}