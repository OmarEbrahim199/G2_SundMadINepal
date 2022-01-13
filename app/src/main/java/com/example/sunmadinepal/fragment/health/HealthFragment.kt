package com.example.sunmadinepal.fragment.health

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.sunmadinepal.R
import com.example.sunmadinepal.databinding.HealthBinding

import com.example.sunmadinepal.ViewModel.HealthViewModel
import com.example.sunmadinepal.model.setLocale
import java.util.*


class HealthFragment : Fragment(){

    private lateinit var healthViewModel : HealthViewModel
    private var _binding: HealthBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        healthViewModel =
            ViewModelProvider(this).get(HealthViewModel::class.java)

        _binding = HealthBinding.inflate(inflater, container, false)
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
        setLocale(this.requireContext(),string)
    }

    fun goToDestinations(){

        binding.apply {

            generalInformation.setOnClickListener{
                findNavController().navigate(R.id.action_navigation_health_to_fragment_generalhealth)
            }
            lady0to6.setOnClickListener {
                findNavController().navigate(R.id.action_navigation_health_to_fragment_0_6_months)
            }
            lady6to9.setOnClickListener {
                findNavController().navigate(R.id.action_navigation_health_to_fragment_06_09_months)
            }
            lady9to12.setOnClickListener {
                findNavController().navigate(R.id.action_navigation_health_to_fragment_09_12_months)
            }
            lady12to24.setOnClickListener {
                findNavController().navigate(R.id.action_navigation_health_to_fragment_12_24_months)
            }
            maternity.setOnClickListener {
                findNavController().navigate(R.id.action_navigation_health_to_fragment_maternity)
            }
        }

    }



}
