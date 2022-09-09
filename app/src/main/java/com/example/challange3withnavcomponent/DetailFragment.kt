package com.example.challange3withnavcomponent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challange3withnavcomponent.Adapter.ItemAdapter
import com.example.challange3withnavcomponent.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val args by navArgs<DetailFragmentArgs>()
    private lateinit var ItemAdapter : ItemAdapter
    private lateinit var hasil : MutableList<Item>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
        (activity as AppCompatActivity).supportActionBar!!.hide()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val idDua = args.idArrays
        val data = resources.getStringArray(idDua)
        hasil = mutableListOf()
        for (i in data){
            hasil.add(Item(i))
        }
        showRecycler()
    }

    private fun showRecycler(){
        ItemAdapter = ItemAdapter(hasil,object : ItemAdapter.Clicked{
            override fun onClicked(item: Item) {
                val siIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=${item.nama}"))
                startActivity(siIntent)
            }
        })

        binding.recycleDua.adapter = ItemAdapter
        binding.recycleDua.layoutManager = LinearLayoutManager(activity)

    }



}