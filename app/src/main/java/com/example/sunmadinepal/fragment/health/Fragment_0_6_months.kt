package com.example.sunmadinepal.fragment.health

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sunmadinepal.R
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

    val string = Locale.getDefault().getLanguage()

    // private var data = ArrayList<RecipesData>()
    private lateinit var Adapter: CustomAdapter
    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = Fragment06MonthsBinding.inflate(inflater, container, false)
        val view = binding?.root
        // Inflate the layout for this fragment
        return view
    }


    override fun onStart() {
        super.onStart()

        //(activity as AppCompatActivity).supportActionBar?.title = "From 0 to 6 months"
        (activity as AppCompatActivity).supportActionBar?.title = getText(R.string.months_0to6)
        binding.apply {


            val recyclerview = binding.recyclerView
            // this creates a vertical layout Manager
            recyclerview.layoutManager = LinearLayoutManager(activity)
            recyclerView.setHasFixedSize(true)

            // ArrayList of class ItemsViewModel


            var data = ArrayList<RecipesData>()



            if(string.equals("en")){

                data.add(RecipesData(R.drawable.app_handwashing.toString(),"Baby 0 - 6 months","Bullet points:\n" +
                        "\n" +
                        "Visit the health post after 24 hours of birth, after 3 days, after 7 days and after 4 months.\n" +
                        "Only breastfeeding is needed. No additional food or water.\n" +
                        "If milk is not enough let the baby suckle more often. This will increase milk production\n" +
                        "Wash hands before feeding baby\n"))

            }

            if(string.equals("ne")){
                data.add(RecipesData(R.drawable.app_handwashing.toString(),"बच्चा ०-६ महिना","महत्वपुर्ण बिन्दु :\n" +
                        "\n" +
                        "स्वास्थ्य चौकीमा जचाउन जाने: बच्चा जन्मेको २४ घन्टाम, तेश्रो दिनमा, सातौ दिनमा र ४ महिना पर्छ \n" +
                        "आमाको दुध मात्र खुवाउने, थप पानी पनि खुवाउनु पर्दैन। \n" +
                        "\n" +
                        "\n" +
                        "दुध नपुगे बच्चालाई चुसाउने, जसले गर्दा दुध उत्पादन हुन्छ। \n" +
                        "बच्चा लै दुध खुवाउनु अघि राम्रो संग हात धुने।\n"))
            }

            // This will pass the ArrayList to our Adapter
            Adapter = CustomAdapter(activity as AppCompatActivity,data, null)

            // Setting the Adapter with the recyclerview
            recyclerview.adapter = Adapter

        }
    }

    private fun EventChangListener() {

        db = FirebaseFirestore.getInstance()
        db.collection("Recipes").addSnapshotListener(object : EventListener<QuerySnapshot> {
            override fun onEvent(value: QuerySnapshot?, error: FirebaseFirestoreException?) {

                if (error != null) {
                    Log.e("Firestore Error", error.message.toString())
                    return
                }

                for (dc: DocumentChange in value?.documentChanges!!) {

                    if (dc.type == DocumentChange.Type.ADDED) {


                        //data.add(dc.document.toObject(RecipesData::class.java))
                        /*  data.add(RecipesData(R.drawable.app_handwashing,"er",
                              dc.document.toObject(RecipesData::class.java).toString()))*/
                    }

                }
                Adapter.notifyDataSetChanged()


            }
        })
    }

}