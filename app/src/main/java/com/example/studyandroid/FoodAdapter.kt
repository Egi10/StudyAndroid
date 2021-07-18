package com.example.studyandroid

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.studyandroid.databinding.ItemListFoodBinding

class FoodAdapter(private val items: List<Food>, private val listener: (Food) -> Unit) :
    RecyclerView.Adapter<FoodAdapter.ViewHolder>() {

    class ViewHolder(
        private val binding: ItemListFoodBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Food, listener: (Food) -> Unit) {
            binding.tvText.text = item.text
            binding.ivImage.load(item.image)

            binding.root.setOnClickListener {
                listener.invoke(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemListFoodBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(items[position], listener)

    override fun getItemCount() = items.size
}