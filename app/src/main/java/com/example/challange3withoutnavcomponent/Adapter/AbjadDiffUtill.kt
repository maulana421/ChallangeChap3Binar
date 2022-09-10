package com.example.challange3withoutnavcomponent.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.challange3withoutnavcomponent.Abjad
import com.example.challange3withoutnavcomponent.R

class AbjadDiffUtill(): RecyclerView.Adapter<AbjadDiffUtill.ViewHolder>() {
    private var diffcallBack = object  : DiffUtil.ItemCallback<Abjad>(){
        override fun areItemsTheSame(oldItem: Abjad, newItem: Abjad): Boolean {
            return oldItem.alphabet == newItem.alphabet
        }

        override fun areContentsTheSame(oldItem: Abjad, newItem: Abjad): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }

    }
    var differ = AsyncListDiffer(this,diffcallBack)
    fun submitData(value : MutableList<Abjad>){
        differ.submitList(value)
    }
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var alpa = itemView.findViewById<TextView>(R.id.tvAlpa)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.alpa.text = differ.currentList[position].alphabet.toString()
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}