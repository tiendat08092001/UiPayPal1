package com.example.uipaypal.data.history_trade

fun historyTradeList(): List<HistoryTrade> {
    return listOf(
        HistoryTrade(
            idTrade = 1,
            nameUserTrade = "El corte inglés",
            isAccept = true,
            isSent = true,
            value = 50
        ),
        HistoryTrade(
            idTrade = 2,
            nameUserTrade = "Maria Lujan",
            isAccept = true,
            isSent = false,
            value = 650
        ),
        HistoryTrade(
            idTrade = 3,
            nameUserTrade = "Maria Lujan",
            isAccept = true,
            isSent = false,
            value = 250
        ),
    )
}