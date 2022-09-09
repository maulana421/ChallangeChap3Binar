package com.example.challange3withnavcomponent

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challange3withnavcomponent.Adapter.AbjadAdapter
import com.example.challange3withnavcomponent.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var AbjadAdapter : AbjadAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
        (activity as AppCompatActivity).supportActionBar!!.hide()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showRecycler()

    }

    private fun showRecycler(){

        var list = mutableListOf<DataAbjad>(DataAbjad('A'),DataAbjad('B'),DataAbjad('C'),DataAbjad('D'),
            DataAbjad('E'),DataAbjad('F'),DataAbjad('G'),DataAbjad('H'),DataAbjad('I'),DataAbjad('J'),
            DataAbjad('K'),DataAbjad('L'),DataAbjad('M'),DataAbjad('N'),DataAbjad('O'),DataAbjad('P'),DataAbjad('Q'),
            DataAbjad('R'),DataAbjad('S'),DataAbjad('T'),DataAbjad('U'),DataAbjad('V'),DataAbjad('W'),DataAbjad('X'),DataAbjad('Y'),DataAbjad('Z'))

        AbjadAdapter = AbjadAdapter(list,object : AbjadAdapter.Clicked{
            override fun onClicked(dataAbjad: DataAbjad) {
                val idSatu = resources.getIdentifier(dataAbjad.alphabet.toString(), "array", (activity as AppCompatActivity).packageName)
                val pindah = MainFragmentDirections.actionMainFragmentToDetailFragment(dataAbjad.alphabet.toString(),idSatu)
                findNavController().navigate(pindah)
            }

        })
        Log.d("LIST","$list")
        binding.recycleSatu.adapter = AbjadAdapter
        binding.recycleSatu.layoutManager = LinearLayoutManager(activity)

    }


}