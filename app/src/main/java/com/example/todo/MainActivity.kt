package com.example.todo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.activities.CreateItem
import com.example.todo.dao.AppDatabase
import com.example.todo.entities.Icons
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : ComponentActivity() {
    private lateinit var db: AppDatabase

    private lateinit var recyclerView: RecyclerView


    private val icons: MutableList<Icons> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the database
        db = AppDatabase.getInstance(applicationContext)

        icons.clear()
        icons.addAll(db.iconsDao().getAll())

        val floatingActionButton = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        floatingActionButton.setOnClickListener {
            val intent = Intent(this@MainActivity, CreateItem::class.java)
            startActivity(intent)
        }

        recyclerView = findViewById(R.id.recView)


        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        val dividerItemDecoration = DividerItemDecoration(this, linearLayoutManager.orientation)
        recyclerView.addItemDecoration(dividerItemDecoration)

        recyclerView.layoutManager = linearLayoutManager

        val iconAdapter = IconAdapter(icons)

        iconAdapter.setOnItemClickListener(object : OnItemClickListener {
            override fun onItemClick(view: View, position: Int) {
                val intent = Intent(this@MainActivity, ItemDetail::class.java)
                intent.putExtra("name", icons[position].name) // Correct method is putExtra
                startActivity(intent)
                // Uncomment the line below if you want to show a Toast message
                // Toast.makeText(this@MainActivity, "Icon clicked: ${icons[position].name}", Toast.LENGTH_SHORT).show()
            }
        })


        recyclerView.adapter = iconAdapter


    }
}