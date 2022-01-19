package com.example.sunmadinepal.fragment.recipes

import android.app.ProgressDialog
import android.content.Context
import android.content.res.Configuration
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.sunmadinepal.R
import com.example.sunmadinepal.databinding.FragmentRecipesBinding
import com.example.sunmadinepal.ViewModel.RecipesViewModel
import com.example.sunmadinepal.model.setLocale
import java.util.*


class RecipesFragment : Fragment() {


    private var _binding: FragmentRecipesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    val string = Locale.getDefault().getLanguage()


    override fun onStart() {
        super.onStart()
        goToDestinations()
        setLocale(this.requireContext(),string)
    }



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

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
                findNavController().navigate(R.id.action_navigation_recipes_to_recipes_Pregnant_Woman_Fragment) }

            recipesForMothers.setOnClickListener{
                findNavController().navigate(R.id.action_navigation_recipes_to_recipes_Mothers_Fragment)
            }
            recipesForChildren.setOnClickListener{
                findNavController().navigate(R.id.action_navigation_recipes_to_recipes_Children_Fragment)
            }

        }
    }
}
