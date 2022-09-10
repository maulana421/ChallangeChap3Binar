package com.example.challange3withoutnavcomponent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.challange3withoutnavcomponent.comunicator.Comunicator
import com.example.challange3withoutnavcomponent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),Comunicator {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)
        firstFragment(MainFragment())
    }

    private fun firstFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.container,fragment).commit()

    }

    override fun datapertama(id: Int, datafirst: Char) {
        val bund = Bundle()
        bund.putInt("id",id)
        bund.putChar("data",datafirst)
        val detailFragment = DetailFragment()
        detailFragment.arguments = bund
        supportFragmentManager.beginTransaction().replace(R.id.container,detailFragment)
            .addToBackStack(null).commit()
    }
}