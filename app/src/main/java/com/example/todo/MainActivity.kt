package com.example.todo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : ComponentActivity() {
    private lateinit var recyclerView: RecyclerView  // Declare RecyclerView with lateinit
    private val fruits: MutableList<Fruit> = mutableListOf(Fruit("Apple", R.drawable.ic_camera), Fruit("Banana", R.drawable.ic_image))


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recView)

        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        val dividerItemDecoration = DividerItemDecoration(this, linearLayoutManager.orientation)
        recyclerView.addItemDecoration(dividerItemDecoration)

        recyclerView.layoutManager = linearLayoutManager


    }
}