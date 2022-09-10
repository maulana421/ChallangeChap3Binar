package com.example.challange3withoutnavcomponent

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challange3withoutnavcomponent.Adapter.AbjadAdapter
import com.example.challange3withoutnavcomponent.comunicator.Comunicator
import com.example.challange3withoutnavcomponent.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var abjadAdapter: AbjadAdapter
    private lateinit var comunicator: Comunicator
    private lateinit var list: MutableList<Abjad>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater)
        comunicator = activity as Comunicator
        return binding.root
        (activity as AppCompatActivity).supportActionBar!!.hide()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showRecycler()
    }

    private fun showRecycler(){
        val list = mutableListOf<Abjad>(Abjad('A'),Abjad('B'),Abjad('C'),Abjad('D'),Abjad('E'),Abjad('F'),Abjad('G'),Abjad('H'),
            Abjad('I'),Abjad('J'),Abjad('K'),Abjad('L'),Abjad('M'),Abjad('N'),Abjad('O'),Abjad('P'),Abjad('Q'),
            Abjad('R'), Abjad('S'),Abjad('T'),Abjad('U'),Abjad('V'),Abjad('W'),Abjad('X'),Abjad('Y'),Abjad('Z'),)

        abjadAdapter = AbjadAdapter(list,object : AbjadAdapter.Clicked{
            override fun onCLicked(abjad: Abjad) {
                val first = resources.getIdentifier(abjad.alphabet.toString(),"array", (activity as AppCompatActivity).packageName)
                comunicator.datapertama(first,abjad.alphabet)
            }
        })
        Log.d("LIST","$list")
        binding.recycleSatu.adapter = abjadAdapter
        binding.recycleSatu.layoutManager = LinearLayoutManager(activity)
    }


}