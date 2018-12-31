package com.laercioag.foodtofork.presentation.recipes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.laercioag.foodtofork.R
import com.laercioag.foodtofork.domain.entity.Recipe
import com.laercioag.foodtofork.extensions.loadImage

class RecipesAdapter : RecyclerView.Adapter<RecipesAdapter.ViewHolder>() {

    private val items: MutableList<Recipe> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recipes_adapter, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.image.loadImage(items[position].imageUrl)
        holder.title.text = items[position].title
    }

    fun setItems(list: List<Recipe>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: AppCompatImageView = itemView.findViewById(R.id.image)
        val title: AppCompatTextView = itemView.findViewById(R.id.title)
    }
}
