package com.example.sunmadinepal.fragment.health

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
import com.example.sunmadinepal.ViewModel.HealthViewModel
import com.example.sunmadinepal.databinding.Fragment0609MonthsBinding
import com.example.sunmadinepal.framework.data.CustomAdapter
import com.example.sunmadinepal.model.RecipesData
import java.util.*
import kotlin.collections.ArrayList


class Fragment_06_09_months : Fragment() {

    private var _binding: Fragment0609MonthsBinding? = null
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
        // Inflate the layout for this fragment
        healthViewModel = ViewModelProvider(this).get(HealthViewModel::class.java)
        _binding = Fragment0609MonthsBinding.inflate(inflater, container, false)
        val view = binding?.root
        // Inflate the layout for this fragment
        return view
    }


    override fun onStart() {
        super.onStart()

        (activity as AppCompatActivity).supportActionBar?.title = getText(R.string.months_6to9)

        getData()
    }


    private fun getData() {

        if (string.equals("en")){
            healthViewModel.fetchEvent_06_09_Months(
                "6to9MonthsExaminationTitleEn","6to9MonthsExaminationDescriptionEn",
                "6to9MonthsFeedingTitleEn","6to9MonthsFeedingDescriptionEn",
                "6to9MonthsWaterTitleEn","6to9MonthsWaterDescriptionEn")

        }else if (string.equals("ne")){
            healthViewModel.fetchEvent_06_09_Months(
                "6to9MonthsExaminationTitleNe","6to9MonthsExaminationDescriptionNe",
                "6to9MonthsFeedingTitleNe","6to9MonthsFeedingDescriptionNe",
                "6to9MonthsWaterTitleNe","6to9MonthsWaterDescriptionNe")
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