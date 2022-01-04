package com.example.sunmadinepal.ui.fragment.health

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sunmadinepal.R
import com.example.sunmadinepal.databinding.Fragment1224MonthsBinding

import com.example.sunmadinepal.databinding.FragmentAgment0612MonthsBinding
import com.example.sunmadinepal.framework.data.CustomAdapter
import com.example.sunmadinepal.model.RecipesData
import java.util.*
import kotlin.collections.ArrayList


class Fragment_06_12_months : Fragment() {

    private var _binding: FragmentAgment0612MonthsBinding? = null
    private val binding get() = _binding!!


    val string = Locale.getDefault().getLanguage()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAgment0612MonthsBinding.inflate(inflater, container, false)
        val view = binding?.root
        // Inflate the layout for this fragment
        return view
    }


    override fun onStart() {
        super.onStart()
        //(activity as AppCompatActivity).supportActionBar?.title = "From 06 to 12 months"
        (activity as AppCompatActivity).supportActionBar?.title = getText(R.string.months_6to12)


        binding.apply {

            val recyclerview = binding.recyclerView

            // this creates a vertical layout Manager
            recyclerview.layoutManager = LinearLayoutManager(activity)

            // ArrayList of class ItemsViewModel


            val data = ArrayList<RecipesData>()
            if(string.equals("en")){

                data.add(RecipesData(R.drawable.app_0_6monthsonlybreastfeeding,"Baby 6 - 9 months","Bullet points:\n" +
                        "\n" +
                        "Visit the healthpost at 6 months and 9 months.\n" +
                        "Start to feed the baby solid food.\n" +
                        "Start with a few spoonfuls 3 times in a day.\n" +
                        "Use jaulo or litto\n" +
                        "(see recipe here)\n" +
                        "Slowly increase upto three bowls per day.\n" +
                        "Give one bowl of jaulo and 2 glass of litto in a day\n" +
                        "Wash your hands with soap before feeding your baby\n" +
                        "\n" +
                        "Swipe to see (example)\n"))

            }

            if(string.equals("ne")){
                data.add(RecipesData(R.drawable.app_0_6monthsonlybreastfeeding,"६-९ ","महत्वपुर्ण बिन्दु :\n" +
                        "\n" +
                        "स्वास्थ्य चौकीमा जचाउन जाने\n" +
                        "बच्चालाई थप पौष्टिक आहार खुवाउन सुरु गर्ने \n" +
                        "सुरु गर्दा दैनिक ३ पटक सम्म केहि चम्चा खाना खुवाउने \n" +
                        "जाउलो र लिटो खुवाउने (बनाउने तरिका यता हेर्नुस)\n" +
                        "पछि बढाएर दैनिक ३ कचौरा सम्म खाना खुवाउने\n" +
                        "\n" +
                        "दैनिक १ कचौरा जाउलो र २ गिलास लिटो खुवाउने। \n" +
                        "\n" +
                        "बच्चालाई  खुवाउनु अघि राम्रो संग साबुन पानीले हात धुने। \n" +
                        "\n" +
                        "\n" +
                        "उदाहरणको लागि अगाडी बढ्नुस\n"))
            }


            // This will pass the ArrayList to our Adapter
            val adapter = CustomAdapter(data, null)

            // Setting the Adapter with the recyclerview
            recyclerview.adapter = adapter


        }
    }


}