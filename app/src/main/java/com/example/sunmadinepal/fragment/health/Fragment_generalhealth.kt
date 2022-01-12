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
import com.example.sunmadinepal.databinding.FragmentGeneralhealthBinding
import com.example.sunmadinepal.framework.data.CustomAdapter
import com.example.sunmadinepal.model.RecipesData
import com.google.firebase.firestore.*
import java.util.*
import kotlin.collections.ArrayList


class Fragment_generalhealth : Fragment() {

    private var _binding: FragmentGeneralhealthBinding? = null
    private val binding get() = _binding!!
    val string = Locale.getDefault().getLanguage()
    private var _events = ArrayList<RecipesData>()
    var progressDialog: ProgressDialog? = null // Creating Progress dialog
    private lateinit var healthViewModel : HealthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        healthViewModel = ViewModelProvider(this).get(HealthViewModel::class.java)
        _binding = FragmentGeneralhealthBinding.inflate(inflater, container, false)
        val view = binding?.root
        // Inflate the layout for this fragment
        return view
    }


    override fun onStart() {
        super.onStart()
        (activity as AppCompatActivity).supportActionBar?.title = "General health information"
        getData()
    }

    private fun getData() {

        if (string.equals("en")){
            healthViewModel.fetchEvent_GeneralHealth("itemName","itemDescription")

        }else if (string.equals("ne")){
            healthViewModel.fetchEvent_GeneralHealth("itemName1","itemDescription1")
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