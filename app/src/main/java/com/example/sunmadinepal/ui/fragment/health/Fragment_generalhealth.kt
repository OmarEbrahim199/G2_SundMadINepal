package com.example.sunmadinepal.ui.fragment.health

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sunmadinepal.R
import com.example.sunmadinepal.databinding.FragmentGeneralhealthBinding
import com.example.sunmadinepal.framework.data.CustomAdapter
import com.example.sunmadinepal.model.RecipesData
import com.google.firebase.firestore.*
import com.google.firebase.firestore.EventListener
import java.util.*
import kotlin.collections.ArrayList


class Fragment_generalhealth : Fragment() {

    private var _binding: FragmentGeneralhealthBinding? = null
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
        _binding = FragmentGeneralhealthBinding.inflate(inflater, container, false)
        val view = binding?.root
        // Inflate the layout for this fragment
        return view
    }


    override fun onStart() {
        super.onStart()
        (activity as AppCompatActivity).supportActionBar?.title = "General health information"

        binding.apply {

            val recyclerview = binding.recyclerView

            // this creates a vertical layout Manager
            recyclerview.layoutManager = LinearLayoutManager(activity)

            // ArrayList of class ItemsViewModel


            val data = ArrayList<RecipesData>()
            if(string.equals("en")){

                data.add(RecipesData(R.drawable.app_go_to_healthpost,"Caring for a sick child","Bullet points:\n" +
                        "\n" +
                        "Sick infants under 6 months of age should be breastfed more often than usual.\n" +
                        "Sick baby who has completed 6 months should be fed mother's milk as well as more nutritious food.\n" +
                        "Even after the baby has recovered, it should be fed once more than usual for two weeks.\n" +
                        "Breastfeeding and breastfeeding as well as special care related to the supplementary food gives strength to fight the disease when sick and helps to recover quickly.\n" +
                        "Timely check-up at the health institution and timely medical treatment should be given.\n" +
                        "Patients should be encouraged to eat slowly and slowly. The patient should not be given too much loose food instead of food.\n" +
                        "Patients should be given tasty food (no need to add salt, spices). If you have sores on your mouth and throat and burns on your chest, you should only eat sour, sour foods.\n" +
                        "To make the patient feel refreshed, gently lift the food before feeding, walk a little and keep it near the window to get fresh air and feed.\n"))
            }

            if(string.equals("ne")){
                data.add(RecipesData(R.drawable.app_go_to_healthpost,"बिरामी बच्चाको स्याहार ","महत्वपुर्ण बिन्दु :\n" +
                        "\n" +
                        "६ महिना भन्दा कम उमेरका बिरामी शिशुलाई आमाको दूध नियमित रूपमा साविक भन्दा बढी पटक खुवाउनुपर्छ।\n" +
                        "६ महिना पुरा भइसकेको बिरामी शिशुलाई आमाको दूधको साथसाथै थप पोषिलो खानाहरु पनि खुवाइरहनु पर्दछ। \n" +
                        "शिशु निको भईसके पछि पनि दुई हप्तासम्म साविक भन्दा थप १ पटक खाना खुवाउनु पर्छ। \n" +
                        "स्तनपान तथा स्तनपान सँगसँगै पुरक खाना सम्बन्धी विशेष हेरचाह बिरामी हुँदा रोगसँग लड्नका लागि तागत दिनुका साथै छिटै स्वास्थ हुन मद्दत गर्दछ।\n" +
                        "समयमै स्वास्थ संस्थामा जाँच गराई समयमै औषधी उपचार गराउनु पर्दछ।\n" +
                        "बिरामीलाई थोरै थोरै छिटो छिटो खाना प्रोत्साहित गर्नुपर्छ। बिरामीलाई खानाको सट्टामा धेरै झोलिलो चीज मात्र दिनु हुँदैन।\n" +
                        "बिरामीलाई स्वादिलो ( चिल्लो , नुन , मसलाहरू बार्नु पर्दैन) खानेकुरा दिनुपर्छ । यदि मुख र घाँटीमा घाउ भयो भने र छाती पोल्यो भने मात्र पिरो , अमिलो खानेकुराहरू बार्नु पर्छ।\n" +
                        "बिरामीलाई ताजगी काे महसुस गराउन खाना खुवाउनु अघि बिस्तारै उठाउने , अलिकति हिँडाउने र ताजा हावा प्राप्त गराउनको लागि झ्यालको नजिकै राख्ने र खाना खुवाउने।\n"))
            }

            // This will pass the ArrayList to our Adapter
            val adapter = CustomAdapter(data, null)

            // Setting the Adapter with the recyclerview
            recyclerview.adapter = adapter

        }
    }

}