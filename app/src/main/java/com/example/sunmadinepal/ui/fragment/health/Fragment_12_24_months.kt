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
import com.example.sunmadinepal.framework.data.CustomAdapter
import com.example.sunmadinepal.model.RecipesData


class Fragment_12_24_months : Fragment() {

    private var _binding: Fragment1224MonthsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.

    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = Fragment1224MonthsBinding.inflate(inflater, container, false)
        val view = binding?.root
        // Inflate the layout for this fragment
        return view
    }

    override fun onStart() {
        super.onStart()
        (activity as AppCompatActivity).supportActionBar?.title = "From 12 to 24months"
        binding.apply {

            val recyclerview = binding.recyclerView

            // this creates a vertical layout Manager
            recyclerview.layoutManager = LinearLayoutManager(activity)

            // ArrayList of class ItemsViewModel
            val data = ArrayList<RecipesData>()

            // This loop will create 20 Views containing
            // the image with the count of view


            data.add(RecipesData(R.drawable.app_handwashing,
                "During pregnancy:",
                "1. Visit the healthpost 4 times during pregnancy\n" +
                        "2. Make sure to eat a balanced diet\n" +
                        "3. Balanced diet means eating food from all 4 food groups.\n" +
                        "4. get plenty of rest.\n" +
                        "5. wash hands after toilet and before eating.\n"))

            data.add(RecipesData(R.drawable.app_go_to_healthpost,
                "During pregnancy:",
                "1. Visit the healthpost 4 times during pregnancy\n" +
                        "2. Make sure to eat a balanced diet\n" +
                        "3. Balanced diet means eating food from all 4 food groups.\n" +
                        "4. get plenty of rest.\n" +
                        "5. wash hands after toilet and before eating.\n"))

            data.add(RecipesData(R.drawable.app_whentowashhands, "During pregnancy:", "1. Visit the healthpost 4 times during pregnancy\n" +
                    "2. Make sure to eat a balanced diet\n" +
                    "3. Balanced diet means eating food from all 4 food groups.\n" +
                    "4. get plenty of rest.\n" +
                    "5. wash hands after toilet and before eating.\n"))



            // This will pass the ArrayList to our Adapter
            val adapter = CustomAdapter(data, null)

            // Setting the Adapter with the recyclerview
            recyclerview.adapter = adapter


        }
    }


}