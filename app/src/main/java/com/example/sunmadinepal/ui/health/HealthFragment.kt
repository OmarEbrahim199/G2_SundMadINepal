package com.example.sunmadinepal.ui.health


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.Observer

import com.example.sunmadinepal.databinding.HealthBinding


class HealthFragment : Fragment(){

    private lateinit var healthViewModel : HealthViewModel
    private var _binding: HealthBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        healthViewModel =
            ViewModelProvider(this).get(HealthViewModel::class.java)

        _binding = HealthBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHealth
        healthViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}
