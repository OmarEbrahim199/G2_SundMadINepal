package com.example.sunmadinepal.ui.fragment.recipes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sunmadinepal.R
import com.example.sunmadinepal.databinding.FragmentRecipesBinding
import com.example.sunmadinepal.framework.data.CustomAdapter
import com.example.sunmadinepal.ui.ViewModel.RecipesViewModel


class RecipesFragment : Fragment() {


    private lateinit var dashboardViewModel: RecipesViewModel
    private var _binding: FragmentRecipesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onStart() {
        super.onStart()
        goToDestinations()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        dashboardViewModel =
            ViewModelProvider(this).get(RecipesViewModel::class.java)

        _binding = FragmentRecipesBinding.inflate(inflater, container, false)
        val root: View = binding.root



        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    fun goToDestinations(){

        binding.apply {

            recipesForPregnantWoman.setOnClickListener {
                findNavController().navigate(R.id.action_navigation_recipes_to_pregant_woman_Fragment) }


            recipesForMothers.setOnClickListener {
                findNavController().navigate(R.id.action_navigation_recipes_to_recipes_for_Mothers_Fragment2)
            }

            recipesForChildren.setOnClickListener {
                findNavController().navigate(R.id.action_navigation_recipes_to_recipes_For_Children_Fragment2)
            }

        }
    }
}