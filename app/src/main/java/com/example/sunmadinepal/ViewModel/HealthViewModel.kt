package com.example.sunmadinepal.ViewModel

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sunmadinepal.R
import com.example.sunmadinepal.model.RecipesData
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings

class HealthViewModel : ViewModel() {



    private var firestore : FirebaseFirestore = FirebaseFirestore.getInstance()
    private var _events = MutableLiveData<List<RecipesData>>()

    private val _text = MutableLiveData<String>().apply {
        value
    }
    val text: LiveData<String> = _text

    init {
        firestore.firestoreSettings = FirebaseFirestoreSettings.Builder().build()
    }

    var ItemImage =""
    var itemName =""
    var itemDescription =""

    internal fun fetchEvent_0_6_Months(ItemName :String, ItemDescription:String) {
        firestore.collection("Recipes").get().addOnCompleteListener{
            if (it.isCanceled){
                Log.e("Error"," Error in database")
            }
            if (it.isSuccessful){
                for (document in it.result!!){

                    ItemImage =document.data.getValue("itemName1").toString()

                    itemName = document.data.getValue(ItemName) as String
                    itemDescription= document.data.getValue(ItemDescription).toString()

                    _events.value =listOf(RecipesData(R.drawable.app_handwashing.toString(),itemName, itemDescription )).
                    plus(listOf(RecipesData(R.drawable.app_handwashing.toString() ,itemName, itemDescription )))



                }


            }
        }.addOnFailureListener { exception ->
            Log.d(ContentValues.TAG, "get failed with ", exception)
        }

    }

    internal fun fetchEvent_06_12_Months(ItemName :String , ItemDescription:String) {
        firestore.collection("Recipes").get().addOnCompleteListener{
            if (it.isCanceled){
                Log.e("Error"," Error in database")
            }
            if (it.isSuccessful){
                for (document in it.result!!){

                    // ItemImage =document.data.getValue("itemName1").toString()
                    itemName = document.data.getValue(ItemName) as String
                    itemDescription= document.data.getValue(ItemDescription).toString()

                    _events.value =listOf(RecipesData(R.drawable.app_0_6monthsonlybreastfeeding.toString(),itemName, itemDescription ))



                }


            }
        }.addOnFailureListener { exception ->
            Log.d(ContentValues.TAG, "get failed with ", exception)
        }

    }

    internal fun fetchEvent_12_24_Months(ItemName :String , ItemDescription:String) {
        firestore.collection("Recipes").get().addOnCompleteListener{
            if (it.isCanceled){
                Log.e("Error"," Error in database")
            }
            if (it.isSuccessful){
                for (document in it.result!!){

                    // ItemImage =document.data.getValue("itemName1").toString()

                    itemName = document.data.getValue(ItemName) as String
                    itemDescription= document.data.getValue(ItemDescription).toString()



                    _events.value =listOf(RecipesData(R.drawable.app_banana.toString(),itemName, itemDescription )).
                    plus(listOf(RecipesData(R.drawable.app_banana.toString() ,itemName, itemDescription )))



                }


            }
        }.addOnFailureListener { exception ->
            Log.d(ContentValues.TAG, "get failed with ", exception)
        }

    }


    internal fun fetchEvent_GeneralHealth(ItemName :String , ItemDescription:String) {
        firestore.collection("Recipes").get().addOnCompleteListener{
            if (it.isCanceled){
                Log.e("Error"," Error in database")
            }
            if (it.isSuccessful){
                for (document in it.result!!){
                    // ItemImage =document.data.getValue("itemName1").toString()
                    itemName = document.data.getValue(ItemName) as String
                    itemDescription= document.data.getValue(ItemDescription).toString()

                    _events.value =listOf(RecipesData(R.drawable.app_go_to_healthpost.toString(),itemName, itemDescription )).
                    plus(listOf(RecipesData(R.drawable.app_go_to_healthpost.toString() ,itemName, itemDescription )))
                }
            }
        }.addOnFailureListener { exception ->
            Log.d(ContentValues.TAG, "get failed with ", exception)
        }
    }

    internal fun fetchEvent_Maternity(ItemName :String , ItemDescription:String) {
        firestore.collection("Recipes").get().addOnCompleteListener{
            if (it.isCanceled){
                Log.e("Error"," Error in database")
            }
            if (it.isSuccessful){
                for (document in it.result!!){
                    // ItemImage =document.data.getValue("itemName1").toString()
                    itemName = document.data.getValue(ItemName) as String
                    itemDescription= document.data.getValue(ItemDescription).toString()

                    _events.value =listOf(RecipesData(R.drawable.app_handwashing.toString(),itemName, itemDescription )).
                    plus(listOf(RecipesData(R.drawable.app_handwashing.toString() ,itemName, itemDescription )))
                }
            }
        }.addOnFailureListener { exception ->
            Log.d(ContentValues.TAG, "get failed with ", exception)
        }
    }



    internal var events : MutableLiveData<List<RecipesData>>
        get() {
            return _events
        }
        set(value) {_events =value}


}
