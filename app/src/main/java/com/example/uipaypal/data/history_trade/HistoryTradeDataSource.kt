package com.example.uipaypal.data.history_trade

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.uipaypal.data.user.UserDataSource

class HistoryTradeDataSource {
    private val initialHistoryTradeList = historyTradeList()
    private val historyTradeLiveData = MutableLiveData(initialHistoryTradeList)

    fun getHistoryTradeList(): LiveData<List<HistoryTrade>> {
        return historyTradeLiveData
    }

    companion object {
        private var INSTANCE: HistoryTradeDataSource? = null

        fun getUserDataSource(): HistoryTradeDataSource {
            return synchronized(HistoryTradeDataSource::class) {
                val newInstance = INSTANCE ?: HistoryTradeDataSource()
                INSTANCE = newInstance
                newInstance
            }
        }
    }
}