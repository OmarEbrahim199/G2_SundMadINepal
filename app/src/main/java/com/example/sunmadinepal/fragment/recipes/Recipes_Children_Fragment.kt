package com.example.sunmadinepal.fragment.recipes

import android.app.ProgressDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sunmadinepal.R
import com.example.sunmadinepal.databinding.FragmentRecipesChildrenBinding
import com.example.sunmadinepal.framework.data.CustomAdapter
import com.example.sunmadinepal.model.RecipesData
import com.example.sunmadinepal.ViewModel.RecipesViewModel
import java.util.*
import kotlin.collections.ArrayList


class Recipes_Children_Fragment : Fragment() {

    private var _binding: FragmentRecipesChildrenBinding? = null
    private val binding get() = _binding!!
    private var _events = ArrayList<RecipesData>()
    var progressDialog: ProgressDialog? = null // Creating Progress dialog

    private lateinit var recipesViewModel : RecipesViewModel

    val string = Locale.getDefault().getLanguage()
   // val locale = Locale(string)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        // Change ActionBar title in fragment
        //(activity as AppCompatActivity).supportActionBar?.title = "Recipes for children"
        (activity as AppCompatActivity).supportActionBar?.title = getText(R.string.recipe_for_children)

        recipesViewModel = ViewModelProvider(this).get(RecipesViewModel::class.java)

        _binding = FragmentRecipesChildrenBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onPause(){
        super.onPause()
    }

    override fun onStart() {
        super.onStart()

        getData()
    }

    private fun getData() {
        if (string.equals("en")){
            recipesViewModel.fetchEventRecipesForChildren("itemName","itemDescription")

        }else if (string.equals("ne")){
            recipesViewModel.fetchEventRecipesForChildren("itemName1","itemDescription1")
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


}