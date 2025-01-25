package com.example.todo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FruitAdapter(private val fruitList: List<Fruit>) : RecyclerView.Adapter<FruitAdapter.ViewHolder>() {

    private val fruits: MutableList<Fruit> = fruitList.toMutableList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Inflate the item layout
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Bind data to the ViewHolder
        val fruit = fruitList[position]
        holder.bind(fruit)
    }

    override fun getItemCount(): Int {
        // Return the size of the list
        return fruitList.size
    }

    // ViewHolder class
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Initialize your views here (e.g., TextView, ImageView)
        // Example: private val textView: TextView = itemView.findViewById(R.id.textView)
        private val textView: TextView = itemView.findViewById(R.id.textView)
        private val imageView: ImageView = itemView.findViewById(R.id.imageView)



        fun bind(fruit: Fruit) {
            // Bind the data to your views here
            // Example: textView.text = fruit.name
            textView.text = fruit.name
            imageView.setImageResource(fruit.image)
        }
    }
}
