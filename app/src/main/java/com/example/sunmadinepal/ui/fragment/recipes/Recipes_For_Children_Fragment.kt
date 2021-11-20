package com.example.sunmadinepal.ui.fragment.recipes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sunmadinepal.R
import com.example.sunmadinepal.databinding.FragmentRecipesForChildrenBinding
import com.example.sunmadinepal.framework.data.CustomAdapter
import com.example.sunmadinepal.model.RecipesData


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
        _binding = FragmentRecipesForChildrenBinding.inflate(inflater ,container, false)
        val view = binding?.root
        // Inflate the layout for this fragment
        return view

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

                data.add(RecipesData(R.drawable.food1,"Rice","Rice is"))
                data.add(RecipesData(R.drawable.food3,"Lasagne","Lasagne is"))
            }

            // This will pass the ArrayList to our Adapter
            val adapter = CustomAdapter(data,null,)

            // Setting the Adapter with the recyclerview
            recyclerview.adapter = adapter
        }



    }


}