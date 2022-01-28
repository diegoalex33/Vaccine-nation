package com.example.vaccine_nation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vaccine_nation.databinding.ActivityVaccinationsListBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.HashMap


class VaccinationListActivity : AppCompatActivity() {

    val vaccinationMap = HashMap<String, Int>()
    private lateinit var binding : ActivityVaccinationsListBinding
    private lateinit var adapter : HeroAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVaccinationsListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val inputStream = resources.openRawResource(R.raw.data)
        val jsonText = inputStream.bufferedReader().use {
            it.readText()
        }

        val gson = Gson()
        val type = object : TypeToken<List<Vaccination>>() { }.type
        val heroes = gson.fromJson<List<Vaccination>>(jsonText, type)
        val heroesList = arrayListOf<Vaccination>()
        heroesList.addAll(heroes)

        adapter = HeroAdapter(heroesList)
        binding.recyclerViewVaccinationList.adapter = adapter
        binding.recyclerViewVaccinationList.layoutManager = LinearLayoutManager(this)
    }
}