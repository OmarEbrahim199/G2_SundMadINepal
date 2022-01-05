package com.example.sunmadinepal.ui.fragment.garden

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.sunmadinepal.R
import com.example.sunmadinepal.databinding.FragmentGardenBinding
import com.example.sunmadinepal.ui.ViewModel.GardenViewModel
import java.util.*


class GardenFragment : Fragment() {

    private lateinit var GardenViewModel: GardenViewModel
    private var _binding: FragmentGardenBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        GardenViewModel =
            ViewModelProvider(this).get(com.example.sunmadinepal.ui.ViewModel.GardenViewModel::class.java)

        _binding = FragmentGardenBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }
    val string = Locale.getDefault().getLanguage()
    override fun onStart() {
        super.onStart()
        goToDestinations()
        setLocale(string)
    }

    fun goToDestinations(){

        binding.apply {

            soil.setOnClickListener{
                findNavController().navigate(R.id.action_navigation_garden_to_soilFragment)
            }
            compost.setOnClickListener {
                findNavController().navigate(R.id.action_navigation_garden_to_compostFragment)
            }
            water.setOnClickListener {
                findNavController().navigate(R.id.action_navigation_garden_to_waterFragment)
            }
            grow.setOnClickListener {
                findNavController().navigate(R.id.action_navigation_garden_to_growingFragment)
            }
        }
    }

    private fun setLocale(code: String) {
        val config = Configuration()
        var locale: Locale? = null
        locale = Locale(code)
        Locale.setDefault(locale)
        config.locale = locale
        this.resources.updateConfiguration(config,
            this.resources.displayMetrics)
    }
}
