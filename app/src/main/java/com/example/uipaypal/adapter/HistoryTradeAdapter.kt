package com.example.uipaypal.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.uipaypal.R
import com.example.uipaypal.data.history_trade.HistoryTrade

class HistoryTradeAdapter(private val onClick: (HistoryTrade) -> Unit) :
    ListAdapter<HistoryTrade, HistoryTradeAdapter.HistoryTradeViewHolder>(historyTradeDiffCallback) {

    class HistoryTradeViewHolder(itemView: View, val onClick: (HistoryTrade) -> Unit) :
        RecyclerView.ViewHolder(itemView) {
        private val userNameHistoryTrade: TextView = itemView.findViewById(R.id.trade_user_name)
        private val isAcceptTextView: TextView = itemView.findViewById(R.id.is_accept)
        private val valueTrade: TextView = itemView.findViewById(R.id.trade_price)
        private var currentHistoryTrade: HistoryTrade? = null
        private val layoutHistoryTrade = itemView.findViewById<ConstraintLayout>(R.id.layout_trade_adapter)

        init {
            itemView.setOnClickListener {
                currentHistoryTrade?.let {
                    onClick(it)
                }
            }
        }

        fun bind(historyTrade: HistoryTrade) {
            currentHistoryTrade = historyTrade
            userNameHistoryTrade.text = historyTrade.nameUserTrade

            if (historyTrade.isAccept) {
                isAcceptTextView.text = "Pago aceptado"
            } else {
                isAcceptTextView.text = "Error!"
            }

            if (historyTrade.isSent) {
                valueTrade.text = "-${historyTrade.value}€"
            } else {
                valueTrade.text = "${historyTrade.value}€"
                valueTrade.setTextColor(Color.parseColor("#00c55b"))
            }

            if (historyTrade.final) {
                layoutHistoryTrade.background = null
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryTradeViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.trade_adapter, parent, false)
        return HistoryTradeViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: HistoryTradeViewHolder, position: Int) {
        val historyTrade = getItem(position)
        holder.bind(historyTrade)
    }
}

object historyTradeDiffCallback : DiffUtil.ItemCallback<HistoryTrade>() {
    override fun areItemsTheSame(oldItem: HistoryTrade, newItem: HistoryTrade): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: HistoryTrade, newItem: HistoryTrade): Boolean {
        return oldItem.idTrade == newItem.idTrade
    }

}