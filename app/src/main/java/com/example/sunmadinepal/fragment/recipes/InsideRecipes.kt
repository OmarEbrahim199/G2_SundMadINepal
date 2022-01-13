package com.example.sunmadinepal.fragment.recipes

import android.content.ContentValues.TAG
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.sunmadinepal.R
import com.example.sunmadinepal.model.loadImage
import java.util.*


class InsideRecipes : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inside_recipes)

        val string = Locale.getDefault().getLanguage()
        val locale = Locale(string)
        Locale.setDefault(locale)

        val food_image: ImageView = findViewById(R.id.ivImage)
        val food_description: TextView = findViewById(R.id.tvwelcome)
        val food_title: TextView = findViewById(R.id.title)


        val bundle: Bundle? = intent.extras
        if (bundle != null) {

            val titlel = bundle.getString("Title")
            (this as AppCompatActivity).supportActionBar?.title = titlel
            food_description.setText(bundle.getString("Description"))
            //  food_image.setImageResource(bundle.getInt("Image"))
            loadImage(food_image, bundle.getString("Image1").toString())


        }


    }
}