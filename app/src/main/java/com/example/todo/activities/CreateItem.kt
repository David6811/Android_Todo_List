package com.example.todo.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.todo.MainActivity
import com.example.todo.R
import com.example.todo.dao.AppDatabase
import com.example.todo.entities.Icons
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CreateItem : AppCompatActivity() {
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_create_item)

        // Initialize the database
        db = AppDatabase.getInstance(applicationContext)

        // Now, you can safely find the button after calling setContentView
        val createButton = findViewById<Button>(R.id.create_button_item_name)
        val nameEditText = findViewById<TextView>(R.id.create_text_item_name)
        createButton.setOnClickListener {
            val iconName = nameEditText.text.toString()
            val iconImage = R.drawable.ic_text // Replace with actual drawable resource ID

            if (iconName.isNotEmpty()) {
                val newIcon = Icons(name = iconName, image = iconImage)

                lifecycleScope.launch(Dispatchers.IO) {
                    db.iconsDao().insertAll(arrayOf(newIcon)) // Runs in background

                    // Switch to the main thread for UI updates
                    launch(Dispatchers.Main) {
                        nameEditText.text = ""
                        Toast.makeText(this@CreateItem, "Create Successfully", Toast.LENGTH_SHORT).show()

                        // Navigate to MainActivity
                        val intent = Intent(this@CreateItem, MainActivity::class.java)
                        startActivity(intent)
                        finish() // Close current activity
                    }
                }
            } else {
                // Show an error message if inputs are invalid
                Toast.makeText(
                    this@CreateItem,
                    "Please provide a name and valid image ID",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

    }
}