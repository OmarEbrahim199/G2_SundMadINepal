package com.example.sunmadinepal.framework.db

import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sunmadinepal.R
import com.example.sunmadinepal.model.RecipesData
import com.google.firebase.firestore.FirebaseFirestore


class CloudData : AppCompatActivity() {

    val data = ArrayList<RecipesData>()

  /*  fun readData(ref: FirebaseDatabase, listener: getSome) {
        listener.onStart()
        ref.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                listener.onSuccess(dataSnapshot)
            }

            fun onCancelled(firebaseError: FirebaseError?) {
                listener.onFailure()
            }
        })
    }*/




    fun getDataFireBase(ItemName :String , ItemDescription:String)  {

        val db = FirebaseFirestore.getInstance()

        db.collection("Recipes").addSnapshotListener { value, error ->


            if(error != null){
                Toast.makeText(this,error.localizedMessage,Toast.LENGTH_LONG).show()

            }
            else{
                if(value != null){
                    if(!value.isEmpty){ //is not empty
                        val documents = value.documents
                        for(document in documents){
                            //casting


                            //Querying the userDetails database searching for the matching userID
                            db.collection("Recipes").get()
                                .addOnSuccessListener { userDocs ->
                                    for (doc in userDocs) {
                                       // userName = doc.get("username") as String // Getting the username from the document
                                        val comment = document.get(ItemName)
                                        val downloadUrl = document.get(ItemDescription)
                                        val post =RecipesData(R.drawable.app_go_to_healthpost.toString(),comment.toString(), downloadUrl.toString() )
                                        data.add(post)
                                    }

                                }
                                .addOnFailureListener { exception ->
                                    Log.d(TAG, "get failed with ", exception)
                                }


                        }
                    }
                }
            }
        }




    }


    fun readFireStoreData(ItemName :String , itemDescription:String){
        val db = FirebaseFirestore.getInstance()

        db.collection("Recipes").get().addOnCompleteListener{

            if (it.isCanceled){
                Log.e("Error"," Error in database")
            }

            if (it.isSuccessful){
                    for (document in it.result!!){

                        val ItemImage = document.data.getValue("ItemImage")
                        val itemName = document.data.getValue(ItemName)
                        val itemDescription= document.data.getValue(itemDescription)



                        data.add(RecipesData(R.drawable.app_go_to_healthpost.toString(),itemName.toString(), itemDescription.toString() ))
                    }

                }
            }
    }

    @JvmName("getData1")
    fun getData(): ArrayList<RecipesData>? {

        return data
    }




}

