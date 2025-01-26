package com.example.todo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.todo.dao.AppDatabase

class ItemDetail : AppCompatActivity() {
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_item_detail)

        // Initialize the database
        db = AppDatabase.getInstance(applicationContext)

        // Safely retrieve the intent data
        val itemNameTextView: TextView = findViewById(R.id.item_name)
        val id = intent?.getIntExtra("id", 0) ?: 0
        val name = intent?.getStringExtra("name") ?: "Unknown" // Safely access intent

        // Set the retrieved name to the TextView
        itemNameTextView.text = name

        val submitButton: Button = findViewById(R.id.submit_item_name)
        submitButton.setOnClickListener {
            // Show a Toast message with the retrieved id
            if (id != 0) {
                //Toast.makeText(this, "ID: $id", Toast.LENGTH_SHORT).show()
                db.iconsDao().deleteItemById(id)
                val intent = Intent(this@ItemDetail, MainActivity::class.java)
                startActivity(intent)

            } else {
                Toast.makeText(this, "ID not available", Toast.LENGTH_SHORT).show()
            }
        }
    }
}