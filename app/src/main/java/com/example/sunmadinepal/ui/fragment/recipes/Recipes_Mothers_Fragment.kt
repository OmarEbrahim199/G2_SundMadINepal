package com.example.sunmadinepal.ui.fragment.recipes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sunmadinepal.R
import com.example.sunmadinepal.databinding.FragmentRecipesMothersBinding
import com.example.sunmadinepal.framework.data.CustomAdapter
import com.example.sunmadinepal.model.RecipesData
import java.util.*
import kotlin.collections.ArrayList

class Recipes_Mothers_Fragment : Fragment() {

    private var _binding: FragmentRecipesMothersBinding? = null
    private val binding get() = _binding!!


    val string = Locale.getDefault().getLanguage()
    val locale = Locale(string)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onStart() {
        super.onStart()

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
            val adapter = CustomAdapter(data,null,)

            // Setting the Adapter with the recyclerview
            recyclerview.adapter = adapter
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentRecipesMothersBinding.inflate(inflater ,container, false)
        val view = binding?.root

        // Change ActionBar title in fragment
        //(activity as AppCompatActivity).supportActionBar?.title = "Recipes for mothers"
        (activity as AppCompatActivity).supportActionBar?.title = getText(R.string.recipe_for_mothers)

        return  view
       // return inflater.inflate(R.layout.fragment_recipes_for__mothers_, container, false)
    }

}