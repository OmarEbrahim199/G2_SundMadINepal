package com.example.sunmadinepal.ui.fragment.recipes

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toDrawable

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sunmadinepal.R
import com.example.sunmadinepal.databinding.FragmentPregantWomanBinding


import com.example.sunmadinepal.framework.data.CustomAdapter
import com.example.sunmadinepal.model.RecipesData
import com.example.sunmadinepal.ui.fragment.Profile.profile_Add
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.auth.User
import com.google.firebase.storage.FirebaseStorage
import com.squareup.picasso.Picasso
import java.io.File
import java.lang.reflect.Array.get
import java.util.*
import kotlin.collections.ArrayList
import com.google.firebase.auth.FirebaseUser
import android.app.ProgressDialog
import android.util.Log
import android.widget.Toast
import com.google.firebase.database.DatabaseError

import com.google.firebase.database.DataSnapshot

import com.google.firebase.database.ValueEventListener

import com.google.firebase.database.DatabaseReference

import com.google.firebase.database.FirebaseDatabase




class Recipes_Pregnant_Woman_Fragment : Fragment() {

    private var _binding: FragmentPregantWomanBinding? = null
    private val binding get() = _binding!!
    val string = Locale.getDefault().getLanguage()
    val locale = Locale(string)

    var progressDialog: ProgressDialog? = null // Creating Progress dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        if (string.equals("en")){
            readFireStoreData("itemName","itemDescription")
        }else if (string.equals("ne")){
            readFireStoreData("itemName1","itemDescription1")
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPregantWomanBinding.inflate(inflater ,container, false)
        val view = binding?.root


        // Change ActionBar title in fragment
        //activity as AppCompatActivity).supportActionBar?.title = "Recipes for pregnant woman"
        (activity as AppCompatActivity).supportActionBar?.title = getText(R.string.recipe_pregnant_woman)

        return  view
    }


    fun getdetails(){


        binding.apply {

            val recyclerview = binding.recyclerView

            // this creates a vertical layout Manager
            recyclerview.layoutManager = LinearLayoutManager(activity)

            // ArrayList of class ItemsViewModel
            val data = ArrayList<RecipesData>()


            if(string.equals("en")){

                data.add(RecipesData(R.drawable.app_jaulo,"Jaulo", "Ingredients:\n" +
                        "Rice\t25 gram\n" +
                        "Mung / pink lentil / split yellow pigeon peas / black gram lentil\t8 gram\n" +
                        "Clarified butter or oil 5 gram\n" +
                        "Green spinach (saag)\taccording to taste\n" +
                        "\n" +
                        "Direction:\n" +
                        "Clean rice and lentils.\n" +
                        "Mix rice and lentil together and soak for half an hour after washing.\n" +
                        "After half an hour, cook in a pan covering with lid using a bit of clarified butter and water.\n" +
                        "While porridge is being cooked, add finely chopped green spinach and cook further covering with lid.\n" +
                        "Add iodized salt for taste.\n"))



                data.add(RecipesData(R.drawable.app_how_to_make_litto,"How to prepare nutritional flour:","Take 2 proportions of different types of grains (corn, barley, rye, millet, oat, rice, etc. one proportio each) and 1 proportion of cereals/lentils (soya, chickpeas, peas, etc). Separately sort/clean and dry roast well until cooked properly and then separately grind store. This flour can be cooked with green spinach, carrot ,milk, clarified butter, honey , eggs, meat, and iodized salt. " ))

            }

            if(string.equals("ne")){
                data.add(RecipesData(R.drawable.app_jaulo,"“जाउलो”\n","चहिने सामग्रीहरु ः\n" +
                        "                      \t\n" +
                        "चमल       २५ ग्राम\n" +
                        "मुंग वा मुसुरो वा रहको वा कालो दाल ८ ग्राम\n" +
                        " घ्यू वा तेल    ५ ग्राम\n" +
                        " हरिायो सागपात  इच्छा अनुसार\n" +
                        " \n" +
                        "बनाउने तरीका ः\n" +
                        "·       चामल र दाललाई केलाउने ।\n" +
                        "·       चामल र दाललाईमिासएर थोरै पानीले आभा घण्टा सम्म भिजाउने ।\n" +
                        " ·       आधा घण्टा पछि थोरै घ्यू र पानी हालेर छोपेर पकाउने ।\n" +
                        "·       पाक्दै गरेको जाउलोमा पिसेको वा मसिनो पारेर टुक्रा गरेको साग पनि मिसाउने र एकछिन छोपेर पकाउने।\n" +
                        "·       स्वादको लागि थोरै आयोडिन युक्त नून हाल्ने ।\n"))


                data.add(RecipesData(R.drawable.app_how_to_make_litto,"“पोषिलो पिठो बनाउने तरिका ः\n”\n","पोषिलो पिठो अन्न समूहबाट भिन्न किसिमका २ भाग अन्न (चामल, गहुँ, मकै, कोदो, जौ, फापर आदि मध्येबाट १÷भाग) र १ भाग गेडागुडी (भटमास, चना केराउ मध्ये आदि) लाई छुट्टाछुट्टै केलाउने र राम्ररी पाक्ने गरि भुट्ने र छुट्टाछुट्टै पिधेर तयार गरिएको पिठोलाई पकाउँदा साग, गाजर , दूध, घ्यू, मह, अण्डा, मासु, आयोडिनयुक्त नुन मिसाई तयार गर्न सकिन्छ ।"))
            }
            // This will pass the ArrayList to our Adapter
            val adapter = CustomAdapter(data, null)

            // Setting the Adapter with the recyclerview
            recyclerview.adapter = adapter

        }

    }

    fun getMal(){
        val recyclerview = binding.recyclerView
        val data = ArrayList<RecipesData>()
        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(activity)


        val rootRef = FirebaseDatabase.getInstance().reference
        val commandsRef = rootRef.child("Recipes").child("itemDescription")
        val eventListener: ValueEventListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (ds in dataSnapshot.children) {
                    val executed = ds.child("executed").getValue(Boolean::class.java)!!!!
                    val text = ds.child("text").getValue(String::class.java)
                    val timestamp = ds.child("timestamp").getValue(Double::class.java)!!!!
                    Log.d("TAG", "$executed / $text / $timestamp")

                    val animal = ds.getValue(RecipesData::class.java)
                    data.add(animal!!)
                    println(animal)

                }
                val adapter = CustomAdapter(data, null)

                // Setting the Adapter with the recyclerview
                recyclerview.adapter = adapter
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(databaseError: DatabaseError) {}
        }
        commandsRef.addListenerForSingleValueEvent(eventListener)

    }


    fun readFireStoreData(ItemName :String , itemDescription:String){
        val df = FirebaseAuth.getInstance()
        val db = FirebaseFirestore.getInstance()

        progressDialog =  ProgressDialog(this.context)

        // Setting up message in Progress dialog.
        progressDialog!!.setMessage("Loading Images From Firebase.");


          // Showing progress dialog.
        progressDialog!!.show();
        val recyclerview = binding.recyclerView
        val data = ArrayList<RecipesData>()


        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(activity)

        db.collection("Recipes")
            .get()
            .addOnCompleteListener{
                if (it.isSuccessful){
                    for (document in it.result!!){

                        val ItemImage = document.data.getValue("ItemImage")
                        val itemName = document.data.getValue(ItemName)
                        val itemDescription= document.data.getValue(itemDescription)

                        progressDialog!!.dismiss()

                        data.add(RecipesData(R.drawable.app_go_to_healthpost,itemName.toString(), itemDescription.toString() ))
                    }
                    // This will pass the ArrayList to our Adapter
                    val adapter = CustomAdapter(data, null)

                    // Setting the Adapter with the recyclerview
                    recyclerview.adapter = adapter
                    adapter.notifyDataSetChanged()
                }
            }


    }

}