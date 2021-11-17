package com.example.sunmadinepal.ui.fragment.recipes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.sunmadinepal.databinding.FragmentRecipesForMothersBinding

class Recipes_for_Mothers_Fragment : Fragment() {

    private var _binding: FragmentRecipesForMothersBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onStart() {
        super.onStart()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentRecipesForMothersBinding.inflate(inflater ,container, false)
        val view = binding?.root

        // Change ActionBar title in fragment
        (activity as AppCompatActivity).supportActionBar?.title = "Recipes for mothers"

        return  view
       // return inflater.inflate(R.layout.fragment_recipes_for__mothers_, container, false)
    }

}