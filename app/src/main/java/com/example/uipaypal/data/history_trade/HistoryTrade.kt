package com.example.uipaypal.data.history_trade

data class HistoryTrade(
    val idTrade: Int,
    val nameUserTrade: String,
    val isAccept: Boolean,
    val isSent: Boolean,
    val value: Int,
    var final: Boolean
)