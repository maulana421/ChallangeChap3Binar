package com.example.challange3withoutnavcomponent.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.challange3withoutnavcomponent.Abjad
import com.example.challange3withoutnavcomponent.Detail
import com.example.challange3withoutnavcomponent.databinding.ItemBinding

class DetailAdapter(val data : MutableList<Detail>,val listern : Clicked): RecyclerView.Adapter<DetailAdapter.DetailViewHolder>() {

    inner class DetailViewHolder(val binding : ItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        return DetailViewHolder(ItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        holder.binding.apply {
            tvAlpa.text = data[position].nama.toString()
            cardSatu.setOnClickListener {
                listern.onClicked(data[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
    interface Clicked {
        fun onClicked(detail: Detail)
    }
}


