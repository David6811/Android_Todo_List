package com.example.todo

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ItemDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_item_detail)

        // Safely retrieve the intent data
        val itemNameTextView: TextView = findViewById(R.id.item_name)
        val name = intent?.getStringExtra("name") ?: "Unknown" // Safely access intent

        // Set the retrieved name to the TextView
        itemNameTextView.text = name
    }
}