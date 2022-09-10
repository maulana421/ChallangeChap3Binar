package com.example.challange3withoutnavcomponent.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.challange3withoutnavcomponent.Abjad
import com.example.challange3withoutnavcomponent.databinding.ItemBinding

class AbjadAdapter(val data : MutableList<Abjad>, val listern : Clicked) : RecyclerView.Adapter<AbjadAdapter.AbjadViewHolder>() {


    inner class AbjadViewHolder (val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AbjadViewHolder {
        return AbjadViewHolder(ItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: AbjadViewHolder, position: Int) {
        holder.binding.apply {
            tvAlpa.text = data[position].alphabet.toString()
            cardSatu.setOnClickListener {
                listern.onCLicked(data[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    interface Clicked {
        fun onCLicked(abjad: Abjad)

    }
}


