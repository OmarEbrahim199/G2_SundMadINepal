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

    internal fun fetchEvent_0_6_Months(ItemName :String, ItemDescription:String,ItemName1 :String, ItemDescription1:String,ItemName2 :String, ItemDescription2:String) {
        firestore.collection("Health").get().addOnCompleteListener{
            if (it.isCanceled){
                Log.e("Error"," Error in database")
            }
            if (it.isSuccessful){
                for (document in it.result!!){

                    //ItemImage =document.data.getValue("itemName1").toString()

                    itemName = document.data.getValue(ItemName) as String
                    itemDescription= document.data.getValue(ItemDescription).toString()
                    val itemName1 = document.data.getValue(ItemName1) as String
                    val itemDescription1= document.data.getValue(ItemDescription1).toString()
                    val itemName2 = document.data.getValue(ItemName2) as String
                    val itemDescription2= document.data.getValue(ItemDescription2).toString()


                    _events.value =listOf(RecipesData(R.drawable.breastfeeding10times.toString(),itemName, itemDescription )).
                    plus(listOf(RecipesData(R.drawable.app_go_to_healthpost.toString() ,itemName1, itemDescription1 ))).
                    plus(listOf(RecipesData(R.drawable.app_handwashing.toString() ,itemName2, itemDescription2 )))
                }
            }
        }.addOnFailureListener { exception ->
            Log.d(ContentValues.TAG, "get failed with ", exception)
        }

    }

    internal fun fetchEvent_06_09_Months(ItemName :String , ItemDescription:String,ItemName1 :String , ItemDescription1:String,ItemName2 :String , ItemDescription2:String) {
        firestore.collection("Health").get().addOnCompleteListener{
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
                    val itemName2 = document.data.getValue(ItemName2) as String
                    val itemDescription2= document.data.getValue(ItemDescription2).toString()

                    _events.value =listOf(RecipesData(R.drawable.app_go_to_healthpost.toString(),itemName, itemDescription )).
                    plus(listOf(RecipesData(R.drawable.app_6to9monthbreastfeedingandfeeding.toString(),itemName1, itemDescription1 ))).
                    plus(listOf(RecipesData(R.drawable.app_boiledwater.toString(),itemName2, itemDescription2 )))
                }
            }
        }.addOnFailureListener { exception ->
            Log.d(ContentValues.TAG, "get failed with ", exception)
        }
    }

    internal fun fetchEvent_09_12_Months(ItemName :String , ItemDescription:String,ItemName1 :String , ItemDescription1:String,ItemName2 :String , ItemDescription2:String) {
        firestore.collection("Health").get().addOnCompleteListener{
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
                    val itemName2 = document.data.getValue(ItemName2) as String
                    val itemDescription2= document.data.getValue(ItemDescription2).toString()

                    _events.value =listOf(RecipesData(R.drawable.app_nojunkfood.toString(),itemName, itemDescription )).
                    plus(listOf(RecipesData(R.drawable.app_balanceddiet_withmeat.toString(),itemName1, itemDescription1 ))).
                    plus(listOf(RecipesData(R.drawable.app_handwashing.toString(),itemName2, itemDescription2 )))
                }
            }
        }.addOnFailureListener { exception ->
            Log.d(ContentValues.TAG, "get failed with ", exception)
        }

    }

    internal fun fetchEvent_12_24_Months(ItemName :String , ItemDescription:String) {
        firestore.collection("Health").get().addOnCompleteListener{
            if (it.isCanceled){
                Log.e("Error"," Error in database")
            }
            if (it.isSuccessful){
                for (document in it.result!!){

                    // ItemImage =document.data.getValue("itemName1").toString()
                    itemName = document.data.getValue(ItemName) as String
                    itemDescription= document.data.getValue(ItemDescription).toString()

                    _events.value =listOf(RecipesData(R.drawable.app_balanceddiet_withmeat.toString(),itemName, itemDescription ))
                }
            }
        }.addOnFailureListener { exception ->
            Log.d(ContentValues.TAG, "get failed with ", exception)
        }

    }


    internal fun fetchEvent_GeneralHealth(ItemName :String , ItemDescription:String,ItemName1 :String , ItemDescription1:String,ItemName2 :String , ItemDescription2:String,ItemName3 :String , ItemDescription3:String,ItemName4 :String , ItemDescription4:String,ItemName5 :String , ItemDescription5:String,ItemName6 :String , ItemDescription6:String,ItemName7 :String , ItemDescription7:String,ItemName8 :String , ItemDescription8:String) {
        firestore.collection("GeneralHealth").get().addOnCompleteListener{
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
                    val itemName2 = document.data.getValue(ItemName2) as String
                    val itemDescription2= document.data.getValue(ItemDescription2).toString()
                    val itemName3 = document.data.getValue(ItemName3) as String
                    val itemDescription3= document.data.getValue(ItemDescription3).toString()
                    val itemName4 = document.data.getValue(ItemName4) as String
                    val itemDescription4= document.data.getValue(ItemDescription4).toString()
                    val itemName5 = document.data.getValue(ItemName5) as String
                    val itemDescription5= document.data.getValue(ItemDescription5).toString()
                    val itemName6 = document.data.getValue(ItemName6) as String
                    val itemDescription6= document.data.getValue(ItemDescription6).toString()
                    val itemName7 = document.data.getValue(ItemName7) as String
                    val itemDescription7= document.data.getValue(ItemDescription7).toString()
                    val itemName8 = document.data.getValue(ItemName8) as String
                    val itemDescription8= document.data.getValue(ItemDescription8).toString()

                    _events.value =listOf(RecipesData(R.drawable.app_growthmonitoring.toString(),itemName, itemDescription )).
                    plus(listOf(RecipesData(R.drawable.app_whentowashhands.toString() ,itemName1, itemDescription1 ))).
                    plus(listOf(RecipesData(R.drawable.kopi_af_vegetable.toString() ,itemName2, itemDescription2 ))).
                    plus(listOf(RecipesData(R.drawable.app_go_to_healthpost.toString() ,itemName3, itemDescription3 ))).
                    plus(listOf(RecipesData(R.drawable.app_go_to_healthpost.toString() ,itemName4, itemDescription4 ))).
                    plus(listOf(RecipesData(R.drawable.app_go_to_healthpost.toString() ,itemName5, itemDescription5 ))).
                    plus(listOf(RecipesData(R.drawable.app_go_to_healthpost.toString() ,itemName6, itemDescription6 ))).
                    plus(listOf(RecipesData(R.drawable.app_go_to_healthpost.toString() ,itemName7, itemDescription7 ))).
                    plus(listOf(RecipesData(R.drawable.app_go_to_healthpost.toString() ,itemName8, itemDescription8 )))
                }
            }
        }.addOnFailureListener { exception ->
            Log.d(ContentValues.TAG, "get failed with ", exception)
        }
    }

    internal fun fetchEvent_Maternity(ItemName :String , ItemDescription:String,ItemName1 :String , ItemDescription1:String,ItemName2 :String , ItemDescription2:String,ItemName3 :String , ItemDescription3:String) {
        firestore.collection("Health").get().addOnCompleteListener{
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
                    val itemName2 = document.data.getValue(ItemName2) as String
                    val itemDescription2= document.data.getValue(ItemDescription2).toString()
                    val itemName3 = document.data.getValue(ItemName3) as String
                    val itemDescription3= document.data.getValue(ItemDescription3).toString()

                    _events.value =listOf(RecipesData(R.drawable.app_go_to_healthpost.toString(),itemName, itemDescription )).
                    plus(listOf(RecipesData(R.drawable.app_balanceddiet_withmeat.toString() ,itemName1, itemDescription1 ))).
                    plus(listOf(RecipesData(R.drawable.app_balanceddiet_withmeat.toString() ,itemName2, itemDescription2 ))).
                    plus(listOf(RecipesData(R.drawable.app_go_to_healthpost.toString() ,itemName3, itemDescription3 )))
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
