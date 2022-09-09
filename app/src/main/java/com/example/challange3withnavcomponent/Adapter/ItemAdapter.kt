package com.example.challange3withnavcomponent.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.challange3withnavcomponent.Item
import com.example.challange3withnavcomponent.databinding.ItemkuBinding

class ItemAdapter(val data : MutableList<Item>, val list : Clicked) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    inner class ItemViewHolder(val binding : ItemkuBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.ItemViewHolder {
        return ItemViewHolder(ItemkuBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ItemAdapter.ItemViewHolder, position: Int) {
        holder.binding.apply {
            tvAlpa.text = data[position].nama.toString()
            cardSatu.setOnClickListener {
                list.onClicked(data[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    interface Clicked {
        fun onClicked(item: Item)

    }
}


