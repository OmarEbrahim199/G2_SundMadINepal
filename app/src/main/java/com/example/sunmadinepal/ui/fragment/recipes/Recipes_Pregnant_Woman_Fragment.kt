package com.example.sunmadinepal.ui.fragment.recipes

import android.content.Context
import android.graphics.ColorSpace
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sunmadinepal.R
import com.example.sunmadinepal.databinding.FragmentPregantWomanBinding


import com.example.sunmadinepal.framework.data.CustomAdapter
import com.example.sunmadinepal.model.RecipesData
import com.example.sunmadinepal.ui.ViewModel.ProfileViewModel
import com.google.android.gms.common.internal.StringResourceValueReader


class Recipes_Pregnant_Woman_Fragment : Fragment() {



    private var _binding: FragmentPregantWomanBinding? = null
    private val binding get() = _binding!!
    private lateinit var profileViewModel: ProfileViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onStart() {
        super.onStart()

        binding.apply {

            val recyclerview = binding.recyclerView

            // this creates a vertical layout Manager
            recyclerview.layoutManager = LinearLayoutManager(activity)

            // ArrayList of class ItemsViewModel
            val data = ArrayList<RecipesData>()

            // This loop will create 20 Views containing
            // the image with the count of view




            for (i in 1..20) {

                data.add(RecipesData(R.drawable.food1,"Jaulo","Ingredients: \n" +
                        "    1-Daal\n" +
                        "    2-Rice\n" +
                        "    3-Vegetables(carrot, pumpkin)\n" +
                        "    4-Water\n\n\n" +

                        "How to prepare\n" +
                        "\n" +
                        "    1-Briefly fry equal amounts of daal and rice in oil\n" +
                        "    2-Add chopped vegetables\n" +
                        "    3-Add water\n" +
                        "    5-Cook in pressure cooker till the ledo is thick\n" +
                        "\n" +
                        ""))


                data.add(RecipesData(R.drawable.food3,"Lasagne","Lasagne is"))
            }

            // This will pass the ArrayList to our Adapter
            val adapter = CustomAdapter(data,null,)

            // Setting the Adapter with the recyclerview
            recyclerview.adapter = adapter




        }


    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPregantWomanBinding.inflate(inflater ,container, false)
        val view = binding?.root


        // Change ActionBar title in fragment
        (activity as AppCompatActivity).supportActionBar?.title = "Recipes for pregnant woman"

        return  view

    }




}