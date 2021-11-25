package com.example.sunmadinepal.ui.fragment.health

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sunmadinepal.R
import com.example.sunmadinepal.databinding.Fragment06MonthsBinding
import com.example.sunmadinepal.databinding.FragmentMaternityBinding
import com.example.sunmadinepal.framework.data.CustomAdapter
import com.example.sunmadinepal.model.RecipesData
import java.util.*
import kotlin.collections.ArrayList

class Fragment_maternity : Fragment() {

    private var _binding: FragmentMaternityBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentMaternityBinding.inflate(inflater, container, false)
        val view = binding?.root
        // Inflate the layout for this fragment
        return view
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onStart() {
        super.onStart()

        // Change ActionBar title in fragment
        (activity as AppCompatActivity).supportActionBar?.title = "Maternity"

        binding.apply {

            val recyclerview = binding.recyclerView

            // this creates a vertical layout Manager
            recyclerview.layoutManager = LinearLayoutManager(activity)

            // ArrayList of class ItemsViewModel
            val data = ArrayList<RecipesData>()

            // This loop will create 20 Views containing
            // the image with the count of view

            val string = Locale.getDefault().getLanguage()
            val locale = Locale(string)
            Locale.setDefault(locale)


            if(string =="en"){
                data.add(RecipesData(R.drawable.app_handwashing,
                    "During pregnancy:",
                    "1. Visit the healthpost 4 times during pregnancy\n" +
                            "2. Make sure to eat a balanced diet\n" +
                            "3. Balanced diet means eating food from all 4 food groups.\n" +
                            "4. get plenty of rest.\n" +
                            "5. wash hands after toilet and before eating.\n"))


                data.add(RecipesData(R.drawable.app_go_to_healthpost,
                    "During pregnancy:",
                    "1. Visit the healthpost 4 times during pregnancy\n" +
                            "2. Make sure to eat a balanced diet\n" +
                            "3. Balanced diet means eating food from all 4 food groups.\n" +
                            "4. get plenty of rest.\n" +
                            "5. wash hands after toilet and before eating.\n"))

                data.add(RecipesData(R.drawable.app_whentowashhands, "During pregnancy:", "1. Visit the healthpost 4 times during pregnancy\n" +
                        "2. Make sure to eat a balanced diet\n" +
                        "3. Balanced diet means eating food from all 4 food groups.\n" +
                        "4. get plenty of rest.\n" +
                        "5. wash hands after toilet and before eating.\n"))

            }

            if(string =="ne") {


                data.add(RecipesData(R.drawable.app_handwashing,
                    "गर्भावस्थाको बेला", "कम्तिमा ४ पटक स्वास्थ्य चौकीमा जचाउन जानुपर्छ। \n" +
                            "पोषिलो खाना खानु जरुरी हुन्छ। \n" +
                            "पोषिलो खाना भन्नाले ४ किसिमका खानाको समूह हो। \n" +
                            "\n" +
                            "\n" +
                            "धेरै मात्रामा आराम गर्ने। \n" +
                            "चर्पीको प्रयोग गरिसकेपछि र खाना खानु अघी राम्रोसंग हात धुने। \n"))

            }







            // This will pass the ArrayList to our Adapter
            val adapter = CustomAdapter(data, null)

            // Setting the Adapter with the recyclerview
            recyclerview.adapter = adapter


        }


    }





}