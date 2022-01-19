package com.example.sunmadinepal.fragment.health

import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sunmadinepal.R
import com.example.sunmadinepal.ViewModel.HealthViewModel
import com.example.sunmadinepal.ViewModel.RecipesViewModel
import com.example.sunmadinepal.databinding.Fragment06MonthsBinding
import com.example.sunmadinepal.framework.data.CustomAdapter
import com.example.sunmadinepal.model.RecipesData
import com.google.firebase.firestore.*

import com.google.firebase.firestore.EventListener
import java.util.*
import kotlin.collections.ArrayList


class Fragment_0_6_months : Fragment() {

    private var _binding: Fragment06MonthsBinding? = null
    private val binding get() = _binding!!
    private var _events = ArrayList<RecipesData>()
    var progressDialog: ProgressDialog? = null // Creating Progress dialog
    private lateinit var healthViewModel : HealthViewModel
    val string = Locale.getDefault().getLanguage()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        healthViewModel = ViewModelProvider(this).get(HealthViewModel::class.java)
        _binding = Fragment06MonthsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        // Inflate the layout for this fragment
        return root
    }


    override fun onStart() {
        super.onStart()
        (activity as AppCompatActivity).supportActionBar?.title = getText(R.string.months_0to6)
        getData()


    }


    private fun getData() {

        if (string.equals("en")){
            healthViewModel.fetchEvent_0_6_Months(
                "0to6MonthsBreastfeedingTitleEn","0to6MonthsBreastfeedingDescriptionEn",
                "0to6MonthsExaminationTitleEn","0to6MonthsExaminationDescriptionEn",
                "0to6MonthsVitaminsTitleEn","0to6MonthsVitaminsDescriptionEn")


        }else if (string.equals("ne")){
            healthViewModel.fetchEvent_0_6_Months(
                "0to6MonthsBreastfeedingTitleNe","0to6MonthsBreastfeedingDescriptionNe",
                "0to6MonthsExaminationTitleNe","0to6MonthsExaminationDescriptionNe",
                "0to6MonthsVitaminsTitleNe","0to6MonthsVitaminsDescriptionNe")
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


        healthViewModel.events.observe(this, androidx.lifecycle.Observer {
                event ->
            _events.removeAll(_events)
            _events.addAll(event)
            progressDialog!!.dismiss()
            recyclerview.adapter!!.notifyDataSetChanged()
        })
    }



}