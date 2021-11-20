package com.example.sunmadinepal.ui.fragment.recipes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.sunmadinepal.R

class InsideRecipes : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inside_recipes)

        val food_image: ImageView = findViewById(R.id.ivImage2)
        val food_description: TextView = findViewById(R.id.tvwelcome)
        val food_title: TextView = findViewById(R.id.title)


        val bundle :Bundle ?=intent.extras
        if (bundle!=null){



            val titlel= bundle.getString("Title")
            (this as AppCompatActivity).supportActionBar?.title =titlel

            food_description.setText(bundle.getString("Description"))
            food_image.setImageResource(bundle.getInt("Image"))


        }







    }
}