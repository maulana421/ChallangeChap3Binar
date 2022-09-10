package com.example.challange3withoutnavcomponent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challange3withoutnavcomponent.Adapter.AbjadAdapter
import com.example.challange3withoutnavcomponent.Adapter.DetailAdapter
import com.example.challange3withoutnavcomponent.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private lateinit var dataRes: MutableList<Detail>
    private lateinit var detailAdapter: DetailAdapter
    private var idSatu : Int = 0
    private var dataSatu : String = ""
    private var array : Array<String> = arrayOf()

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
        dataSatu = arguments?.getChar("data").toString()
        idSatu = arguments?.getInt("id")!!
        array = resources.getStringArray(idSatu)
        dataRes = mutableListOf()
        for (i in array){
            dataRes.add(Detail(i))
        }
        showRecycler()

    }

    private fun showRecycler(){
        detailAdapter = DetailAdapter(dataRes,object : DetailAdapter.Clicked{
            override fun onClicked(detail: Detail) {
                val siIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=${detail.nama}"))
                startActivity(siIntent)
            }
        })

        binding.recycleDua.adapter = detailAdapter
        binding.recycleDua.layoutManager = LinearLayoutManager(activity)

    }





}