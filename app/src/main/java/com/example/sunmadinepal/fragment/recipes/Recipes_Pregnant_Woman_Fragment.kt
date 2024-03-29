package com.example.sunmadinepal.fragment.recipes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sunmadinepal.R
import com.example.sunmadinepal.databinding.FragmentPregantWomanBinding
import com.example.sunmadinepal.database.adapter.CustomAdapter
import com.example.sunmadinepal.model.RecipesData
import java.util.*
import kotlin.collections.ArrayList
import android.app.ProgressDialog
import androidx.lifecycle.ViewModelProvider
import com.example.sunmadinepal.ViewModel.RecipesViewModel


class Recipes_Pregnant_Woman_Fragment : Fragment() {

    private var _binding: FragmentPregantWomanBinding? = null
    private val binding get() = _binding!!
    val string = Locale.getDefault().getLanguage()
    val locale = Locale(string)
    private lateinit var recipesViewModel: RecipesViewModel
    private var _events = ArrayList<RecipesData>()
    var progressDialog: ProgressDialog? = null // Creating Progress dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }



    override fun onStart() {
        super.onStart()

        if (string.equals("en")){
            recipesViewModel.fetchEventRecipeForPregnant(
                "JauloTitleEn","JauloDescriptionEn",
                "LittoTitleEn", "LittoDescriptionEn",
                "NutritiousFlourTitleEn","NutritiousFlourDescriptionEn",
                "PumpkinPuddingTitleEn", "PumpkinPuddingDescriptionEn")
        }else if (string.equals("ne")){
            recipesViewModel.fetchEventRecipeForPregnant(
                "JauloTitleNe","JauloDescriptionNe",
                "LittoTitleNe","LittoDescriptionNe",
                "NutritiousFlourTitleNe","NutritiousFlourDescriptionNe",
                "PumpkinPuddingTitleNe", "PumpkinPuddingDescriptionNe")
        }
            progressDialog =  ProgressDialog(this.context)
            // Setting up message in Progress dialog.
            progressDialog!!.setMessage("Loading Data From Firebase.");
            //Showing progress dialog.
            progressDialog!!.show()

            val recyclerview = binding.recyclerView
            // this creates a vertical layout Manager
            recyclerview.hasFixedSize()
            recyclerview.layoutManager = LinearLayoutManager(activity)
            val adapter = CustomAdapter(activity as AppCompatActivity,_events, null)
            recyclerview.adapter = adapter


        recipesViewModel.events.observe(this, androidx.lifecycle.Observer {
            event ->
            _events.removeAll(_events)
            _events.addAll(event)
            progressDialog!!.dismiss()
            recyclerview.adapter!!.notifyDataSetChanged()
        })

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        recipesViewModel = ViewModelProvider(this).get(RecipesViewModel::class.java)
        _binding = FragmentPregantWomanBinding.inflate(inflater ,container, false)
        val view = binding?.root


        // Change ActionBar title in fragment
        (activity as AppCompatActivity).supportActionBar?.title = getText(R.string.recipe_pregnant_woman)

        return  view
    }



}


