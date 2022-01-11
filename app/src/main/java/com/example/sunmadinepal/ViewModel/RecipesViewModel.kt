package com.example.sunmadinepal.ViewModel


import android.app.Activity
import android.app.ProgressDialog
import android.content.ContentValues
import android.graphics.BitmapFactory
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import com.example.sunmadinepal.R
import com.example.sunmadinepal.framework.data.CustomAdapter
import com.example.sunmadinepal.model.RecipesData
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings



class RecipesViewModel : ViewModel() {

    private var firestore : FirebaseFirestore = FirebaseFirestore.getInstance()
    private var _events = MutableLiveData<List<RecipesData>>()
    var progressDialog: ProgressDialog? = null // Creating Progress dialog


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

    internal fun fetchEventRecipesForChildren(ItemName :String , ItemDescription:String) {
        firestore.collection("Recipes").get().addOnCompleteListener{
            if (it.isCanceled){
                Log.e("Error"," Error in database")
            }
            if (it.isSuccessful){
                for (document in it.result!!){

                     ItemImage =document.data.getValue("itemName1").toString()

                     itemName = document.data.getValue(ItemName) as String
                     itemDescription= document.data.getValue(ItemDescription).toString()

                    _events.value =listOf(RecipesData(R.drawable.food3.toString(),itemName, itemDescription )).
                    plus(listOf(RecipesData(R.drawable.app_spinach_saag_for_jaulo.toString() ,itemName, itemDescription )))



                }


            }
        }.addOnFailureListener { exception ->
            Log.d(ContentValues.TAG, "get failed with ", exception)
        }

    }

    internal fun fetchEventRecipeForPregnant(ItemName :String , ItemDescription:String,ItemName1 :String , ItemDescription1:String) {
        firestore.collection("Recipes").get().addOnCompleteListener{
            if (it.isCanceled){
                Log.e("Error"," Error in database")
            }
            if (it.isSuccessful){
                for (document in it.result!!){

                   // ItemImage =document.data.getValue("itemName1").toString()

                    itemName = document.data.getValue(ItemName) as String
                    itemDescription= document.data.getValue(ItemDescription).toString()
                   val itemName1 = document.data.getValue(ItemName1) as String
                    val itemDescription1= document.data.getValue(ItemDescription1).toString()




                    _events.value =listOf(RecipesData(R.drawable.app_balanceddiet_withmeat.toString(),itemName, itemDescription )).
                    plus(listOf(RecipesData(R.drawable.app_0_6monthsonlybreastfeeding.toString() ,itemName1, itemDescription1 )))



                }


            }
        }.addOnFailureListener { exception ->
            Log.d(ContentValues.TAG, "get failed with ", exception)
        }

    }

    internal fun fetchEventRecipeForMothers(ItemName :String , ItemDescription:String) {
        firestore.collection("Recipes").get().addOnCompleteListener{
            if (it.isCanceled){
                Log.e("Error"," Error in database")
            }
            if (it.isSuccessful){
                for (document in it.result!!){

                    // ItemImage =document.data.getValue("itemName1").toString()

                    itemName = document.data.getValue(ItemName) as String
                    itemDescription= document.data.getValue(ItemDescription).toString()



                    _events.value =listOf(RecipesData(R.drawable.app_balanceddiet_withmeat.toString(),itemName, itemDescription )).
                    plus(listOf(RecipesData(R.drawable.app_0_6monthsonlybreastfeeding.toString() ,itemName, itemDescription )))



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


