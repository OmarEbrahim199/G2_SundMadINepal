package com.example.sunmadinepal.framework.db

import android.app.ProgressDialog
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sunmadinepal.R
import com.example.sunmadinepal.framework.data.CustomAdapter
import com.example.sunmadinepal.model.RecipesData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class Firebase : AppCompatActivity(){

    fun readFireStoreData(ItemName :String , itemDescription:String){

        val df = FirebaseAuth.getInstance()
        val db = FirebaseFirestore.getInstance()





        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        val data = ArrayList<RecipesData>()


        // this creates a vertical layout Manager
        Log.d("FirebaseLog","Before recyclerview line 31")
        recyclerView.layoutManager = LinearLayoutManager(this)
        Log.d("FirebaseLog","After Recyclerview line 32")

        db.collection("Recipes")
            .get()
            .addOnCompleteListener{
                if (it.isSuccessful){
                    for (document in it.result!!){

                        val ItemImage = document.data.getValue("ItemImage")
                        val itemName = document.data.getValue(ItemName)
                        val itemDescription= document.data.getValue(itemDescription)


                        data.add(RecipesData(R.drawable.app_go_to_healthpost,itemName.toString(), itemDescription.toString() ))
                    }
                    // This will pass the ArrayList to our Adapter
                    val adapter = CustomAdapter(data, null)

                    // Setting the Adapter with the recyclerview
                    recyclerView.adapter = adapter
                    adapter.notifyDataSetChanged()
                }
            }
    }





}