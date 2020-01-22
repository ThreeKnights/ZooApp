package com.adsulganesh.zooapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_animal_details.*

class AnimalDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_details)

        val bundle:Bundle = intent.extras!!

        val name = bundle.getString("name")
        val desc = bundle.getString("desc")
        val image = bundle.getInt("image")

        ivAnimalImage.setImageResource(image)
        tvAnimalName.text = name
        tvAnimalDesc.text = desc

    }
}
