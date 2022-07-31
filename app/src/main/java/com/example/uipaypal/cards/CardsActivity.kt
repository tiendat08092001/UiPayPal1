package com.example.uipaypal.cards

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uipaypal.R
import com.example.uipaypal.adapter.CardsAdapter
import com.example.uipaypal.data.cards.Card

class CardsActivity : AppCompatActivity() {
    private val cardsViewModel by viewModels<CardsViewModel> {
        CardsViewModelFactory(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cards)


        //recycle view card
        val linearLayoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val cardsAdapter = CardsAdapter { card -> onClickCard(card) }
        val recyclerViewCard = findViewById<RecyclerView>(R.id.card_list)
        recyclerViewCard.adapter = cardsAdapter
        recyclerViewCard.layoutManager = linearLayoutManager
        cardsViewModel.cardsLiveData.observe(this) {
            cardsAdapter.submitList(it as MutableList<Card>)
        }


        //back to main activity
        val imageBack: ImageButton = findViewById(R.id.back_from_cards_to_mainActivity)
        imageBack.setOnClickListener {
            finish()
        }
    }

    private fun onClickCard(card: Card) {

    }
}