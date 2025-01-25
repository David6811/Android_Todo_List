package com.example.todo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : ComponentActivity() {
    private lateinit var recyclerView: RecyclerView  // Declare RecyclerView with lateinit
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

        recyclerView = findViewById(R.id.recView)

        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        val dividerItemDecoration = DividerItemDecoration(this, linearLayoutManager.orientation)
        recyclerView.addItemDecoration(dividerItemDecoration)

        recyclerView.layoutManager = linearLayoutManager

        val iconAdapter = IconAdapter(icons)

        // Set the adapter for the RecyclerView
        recyclerView.adapter = iconAdapter


    }
}