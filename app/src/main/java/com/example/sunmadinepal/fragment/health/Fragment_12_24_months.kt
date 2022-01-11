package com.example.sunmadinepal.fragment.health

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sunmadinepal.R
import com.example.sunmadinepal.databinding.Fragment1224MonthsBinding
import com.example.sunmadinepal.framework.data.CustomAdapter
import com.example.sunmadinepal.model.RecipesData
import java.util.*
import kotlin.collections.ArrayList


class Fragment_12_24_months : Fragment() {

    private var _binding: Fragment1224MonthsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.

    val string = Locale.getDefault().getLanguage()

    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = Fragment1224MonthsBinding.inflate(inflater, container, false)
        val view = binding?.root
        // Inflate the layout for this fragment
        return view
    }

    override fun onStart() {
        super.onStart()
        //(activity as AppCompatActivity).supportActionBar?.title = "From 12 to 24months"
        (activity as AppCompatActivity).supportActionBar?.title = getText(R.string.months_12to24)

        binding.apply {

            val recyclerview = binding.recyclerView

            // this creates a vertical layout Manager
            recyclerview.layoutManager = LinearLayoutManager(activity)

            // ArrayList of class ItemsViewModel
            val data = ArrayList<RecipesData>()

            if(string.equals("en")){

                data.add(RecipesData(R.drawable.app_banana.toString(),"Baby 9 - 12 months:","9 - 12 months\n" +
                        "Visit the healthpost when the baby is 9 months old.\n" +
                        "Give 3 meals in a day +  1 snack\n" +
                        "Breastfeed frequently\n" +
                        "Make litto and jaulo. \n" +
                        "Give fruit as a snack.\n" +
                        "Never give junkfood.\n" +
                        "Use clean and safe water.\n" +
                        "Wash hands before feeding\n"))

            }

            if(string.equals("ne")){
                data.add(RecipesData(R.drawable.app_banana.toString(),"बच्चा ०-९ महिना "," ०-९ महिना\n" +
                        " बच्चाले ९ महिना पुगेपछि स्वास्थ्य चौकीमा जचाउन जानुपर्छ ।\n" +
                        "\n" +
                        "दैनिक ३ पटक खाना र एक पटक खाजा खुवाउनु पर्छ \n" +
                        "आमाको दुध पटक पटक खुवाउने। \n" +
                        "लिटो र जाउलो बनाएर खुवाउन। \n" +
                        "खाजाको लागि फलफुल खुवाउन। \n" +
                        "बाहिरको खाना नदिने। \n" +
                        "सफा र सुरक्षित पानीको प्रयोग गर्ने । \n" +
                        "बच्चालाई  खुवाउनु अघि राम्रो संग हात धुने।\n"))
            }


            // This will pass the ArrayList to our Adapter
            val adapter = CustomAdapter(activity as AppCompatActivity,data, null)

            // Setting the Adapter with the recyclerview
            recyclerview.adapter = adapter


        }
    }


}