package com.example.sunmadinepal.ui.fragment.recipes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.sunmadinepal.R
import com.example.sunmadinepal.databinding.FragmentRecipesForChildrenBinding


class Recipes_For_Children_Fragment : Fragment() {

    private var _binding: FragmentRecipesForChildrenBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        // Change ActionBar title in fragment
        (activity as AppCompatActivity).supportActionBar?.title = "Recipes for children"

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recipes__for__children_, container, false)

    }

    override fun onStart() {
        super.onStart()
    }

    companion object {
        const val TAG = "DetailsFragment"
    }

}