package com.example.uipaypal.data.user

import com.example.uipaypal.R

fun userList(): List<User> {
    return listOf(
        User(id = 1, name = "Carlos Roca", image = R.drawable.user_image2),
        User(id = 2, name = "Ruby Sanz", image = R.drawable.user_image3),
        User(id = 3, name = "Mary Rich", image = R.drawable.user_image1),
        User(id = 4, name = "José Porto", image = R.drawable.user_image4),
    )
}