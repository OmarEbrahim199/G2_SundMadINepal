package com.example.sunmadinepal.ui.fragment.health

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sunmadinepal.R
import com.example.sunmadinepal.databinding.Fragment06MonthsBinding
import com.example.sunmadinepal.databinding.FragmentRecipesForChildrenBinding
import com.example.sunmadinepal.framework.data.CustomAdapter
import com.example.sunmadinepal.model.RecipesData
import com.google.firebase.firestore.*
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.database.DatabaseReference

import com.google.firebase.database.FirebaseDatabase


class Fragment_0_6_months : Fragment() {

    private var _binding: Fragment06MonthsBinding? = null
    private val binding get() = _binding!!


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

        (activity as AppCompatActivity).supportActionBar?.title = "From 0 to 6 months"
        binding.apply {


            val recyclerview = binding.recyclerView
            // this creates a vertical layout Manager
            recyclerview.layoutManager = LinearLayoutManager(activity)
            recyclerView.setHasFixedSize(true)

            // ArrayList of class ItemsViewModel


            var data = ArrayList<RecipesData>()

            // This will pass the ArrayList to our Adapter
            Adapter = CustomAdapter(data, null)

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


                /*
                 val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("message")

        myRef.setValue("Hello, World!")
                 */
            }
        })
    }

}