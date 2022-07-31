package com.example.uipaypal.data.history_trade

fun historyTradeList(): List<HistoryTrade> {
    val list =  listOf(
        HistoryTrade(
            idTrade = 1,
            nameUserTrade = "El corte inglés",
            isAccept = true,
            isSent = true,
            value = 50,
            final = false
        ),
        HistoryTrade(
            idTrade = 2,
            nameUserTrade = "Maria Lujan",
            isAccept = true,
            isSent = false,
            value = 650,
            final = false
        ),
        HistoryTrade(
            idTrade = 3,
            nameUserTrade = "Maria Lujan",
            isAccept = true,
            isSent = false,
            value = 250,
            final = false
        )
    ) // chứa dữ liệu
    list.last().final = true
    return list
}