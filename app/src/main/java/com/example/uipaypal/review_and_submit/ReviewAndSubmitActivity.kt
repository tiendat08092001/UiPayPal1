package com.example.uipaypal.review_and_submit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.example.uipaypal.R

class ReviewAndSubmitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review_and_submit)

        val btnBack = findViewById<ImageView>(R.id.btn_back_to_main_activity)
        btnBack.setOnClickListener {
            finish()
        }
    }
}