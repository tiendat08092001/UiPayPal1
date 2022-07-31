package com.example.uipaypal.cards

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.uipaypal.data.cards.CardDataSource

class CardsViewModel(val cardDataSource: CardDataSource) : ViewModel() {
    val cardsLiveData = cardDataSource.getCardList()
}

class CardsViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CardsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CardsViewModel(
                cardDataSource = CardDataSource.getCardDataSouce()
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}