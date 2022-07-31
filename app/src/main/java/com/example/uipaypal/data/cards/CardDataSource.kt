package com.example.uipaypal.data.cards

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class CardDataSource {
    private val initialHistoryTradeList = cardsList()
    private val cardLiveData = MutableLiveData(initialHistoryTradeList)

    fun getCardList(): LiveData<List<Card>> {
        return cardLiveData
    }

    companion object {
        private var INSTANCE: CardDataSource? = null

        fun getCardDataSouce(): CardDataSource {
            return synchronized(CardDataSource::class.java) {
                val newInstance = INSTANCE ?: CardDataSource()
                INSTANCE = newInstance
                newInstance
            }
        }
    }
}