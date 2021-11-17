package com.example.sunmadinepal.ui.fragment.recipes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.example.sunmadinepal.databinding.FragmentPregantWomanBinding


class Recipes_Pregnant_Woman_Fragment : Fragment() {


    private var _binding: FragmentPregantWomanBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onStart() {
        super.onStart()

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
        //return inflater.inflate(R.layout.fragment_pregant_woman_, container, false)
    }






}