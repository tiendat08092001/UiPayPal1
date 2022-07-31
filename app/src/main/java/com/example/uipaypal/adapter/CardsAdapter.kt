package com.example.uipaypal.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.uipaypal.R
import com.example.uipaypal.data.cards.Card
import com.example.uipaypal.data.user.User

class CardsAdapter(private val onClick: (Card) -> Unit) :
    ListAdapter<Card, CardsAdapter.CardViewHolder>(CardDiffCallback) {

    class CardViewHolder(itemView: View, val onClick: (Card) -> Unit) :
        RecyclerView.ViewHolder(itemView) {

        private val imageCard: ImageView = itemView.findViewById(R.id.image_card_list)
        private val categoryCard: TextView = itemView.findViewById(R.id.category_card)
        private val codeCard: TextView = itemView.findViewById(R.id.code_card)
        private val popupMenuBtn = itemView.findViewById<ImageButton>(R.id.btn_popup_menu)
        private val linearLayoutPopupMenu = itemView.findViewById<LinearLayout>(R.id.popup_menu)
        private val btnESC: ImageButton = itemView.findViewById(R.id.popup_menu_btn_esc)

        private var currentCard: Card? = null

        init {
            itemView.setOnClickListener {
                currentCard?.let {
                    onClick(it)
                }
            }

            popupMenuBtn.setOnClickListener {
                linearLayoutPopupMenu.visibility = View.VISIBLE
            }

            btnESC.setOnClickListener {
                linearLayoutPopupMenu.visibility = View.GONE
            }

        }

        fun bind(card: Card) {
            imageCard.setImageResource(card.imageCard)
            categoryCard.text = card.categoryCard
            codeCard.text = card.codeCard
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.carlist_adapter, parent, false)
        return CardViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val card = getItem(position)
        return holder.bind(card)
    }
}

object CardDiffCallback : DiffUtil.ItemCallback<Card>() {

    override fun areItemsTheSame(oldItem: Card, newItem: Card): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Card, newItem: Card): Boolean {
        return oldItem.idCard == newItem.idCard
    }
}