package com.example.vaccine_nation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.vaccine_nation.databinding.ActivityVaccinationsDetailBinding

class VaccinationDetailActivity {
    private lateinit var binding: ActivityVaccinationsDetailBinding

    companion object {
        val EXTRA_VACCINATION = "The vaccination"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVaccinationsDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val hero = intent.getParcelableExtra<Vaccination>(EXTRA_VACCINATION)

        binding.textViewHeroDetailName.text = hero?.name
        binding.imageViewHeroDetailImage.setImageDrawable(
            getDrawable(resources.getIdentifier(hero?.image, "drawable", packageName))
        )
        binding.textViewHeroDetailDescription.text = hero?.description
        binding.textViewHeroDetailRanking.text = "" + hero?.ranking
        binding.textViewHeroDetailSuperpower.text = hero?.superpower
    }
}