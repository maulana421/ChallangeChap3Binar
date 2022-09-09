package com.example.challange3withnavcomponent.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.example.challange3withnavcomponent.DataAbjad
import com.example.challange3withnavcomponent.R
import com.example.challange3withnavcomponent.databinding.ItemkuBinding
import kotlinx.android.synthetic.main.itemku.view.*

class AbjadAdapter(val data : MutableList<DataAbjad>, val list : Clicked): RecyclerView.Adapter<AbjadAdapter.DataAbjadViewHolder>() {
    inner class DataAbjadViewHolder (val binding: ItemkuBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataAbjadViewHolder {
        return DataAbjadViewHolder(ItemkuBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: DataAbjadViewHolder, position: Int) {
        holder.binding.apply {
            tvAlpa.text = data[position].alphabet.toString()
            cardSatu.setOnClickListener {
                list.onClicked(data[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    interface Clicked {
        fun onClicked(dataAbjad: DataAbjad)

    }


}




