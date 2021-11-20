package com.example.sunmadinepal.ui.fragment.health

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sunmadinepal.R
import com.example.sunmadinepal.databinding.Fragment06MonthsBinding
import com.example.sunmadinepal.databinding.FragmentRecipesForChildrenBinding
import com.example.sunmadinepal.framework.data.CustomAdapter
import com.example.sunmadinepal.model.RecipesData

class Fragment_0_6_months : Fragment() {

    private var _binding: Fragment06MonthsBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = Fragment06MonthsBinding.inflate(inflater ,container, false)
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

            // ArrayList of class ItemsViewModel
            val data = ArrayList<RecipesData>()

            // This loop will create 20 Views containing
            // the image with the count of view






                data.add(RecipesData(R.drawable.app_handwashing,"Baby 0 - 6 months","\n" +
                        "Bullet points:\n" +
                        "\n" +
                        "1. Visit the health post after 24 hours of birth, after 3 days, after 7 days and after 4 months.\n" +
                        "2. Only breastfeeding is needed. No additional food or water.\n" +
                        "3. If milk is not enough let the baby suckle more often. This will increase milk production\n" +
                        "4. Wash hands before feeding baby\n"))




            // This will pass the ArrayList to our Adapter
            val adapter = CustomAdapter(data,null,)

            // Setting the Adapter with the recyclerview
            recyclerview.adapter = adapter




        }











    }

}