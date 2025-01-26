package com.example.todo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.entities.Icons

class IconAdapter(private val iconList: List<Icons>) :
    RecyclerView.Adapter<IconAdapter.ViewHolder>() {

    private lateinit var onItemClickListener: OnItemClickListener

    fun setOnItemClickListener(listener: OnItemClickListener) {
        onItemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Inflate the item layout
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Bind data to the ViewHolder
        val icon = iconList[position]
        holder.bind(icon)
        holder.itemView.setOnClickListener {
            onItemClickListener.onItemClick(holder.itemView, position)
        }
    }

    override fun getItemCount(): Int {
        return iconList.size
    }

    // ViewHolder class
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textView: TextView = itemView.findViewById(R.id.textView)
        private val imageView: ImageView = itemView.findViewById(R.id.imageView)

        fun bind(icon: Icons) {
            // Bind the data to your views here
            textView.text = icon.name
            icon.image?.let { imageView.setImageResource(it) }
        }
    }
}
