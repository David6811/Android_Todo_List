package com.example.todo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : ComponentActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var fbt: FloatingActionButton
    private val icons: MutableList<Icon> = mutableListOf(
        Icon("Camera", R.drawable.ic_camera),
        Icon("Checkbox", R.drawable.ic_checkbox),
        Icon("Date", R.drawable.ic_date),
        Icon("Edit", R.drawable.ic_edit),
        Icon("Image", R.drawable.ic_image),
        Icon("List", R.drawable.ic_list),
        Icon("Rating", R.drawable.ic_rating),
        Icon("Text", R.drawable.ic_text),
        Icon("Time", R.drawable.ic_time),
        Icon("Toggle", R.drawable.ic_toggle)
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val floatingActionButton = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        floatingActionButton.setOnClickListener {
            // Handle click event here
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