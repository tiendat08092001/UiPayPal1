package com.example.uipaypal.data.cards

import com.example.uipaypal.R

fun cardsList(): List<Card> {
    return listOf(
        Card(
            idCard = 1,
            imageCard = R.drawable.ic_mastercard_2,
            categoryCard = "Mastercard",
            codeCard = "****9889"
        ),
        Card(
            idCard = 2,
            imageCard = R.drawable.ic_visa_card,
            categoryCard = "Visa black",
            codeCard = "****8764"
        ),
        Card(
            idCard = 3,
            imageCard = R.drawable.ic_visa_card,
            categoryCard = "Visa black",
            codeCard = "****8764"
        ),
    )

}