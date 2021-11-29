package com.example.sunmadinepal.ui.fragment.Profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.Observer

import com.example.sunmadinepal.databinding.FragmentProfileBinding
import com.example.sunmadinepal.ui.ViewModel.ProfileViewModel




class ProfileFragment : Fragment() {


    private lateinit var profileViewModel: ProfileViewModel
    private var _binding:FragmentProfileBinding ? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        profileViewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root


/*
        val textView= binding.textProfile
        profileViewModel.text.observe(viewLifecycleOwner, Observer { textView.text = it })*/



       /* val btn : Button =binding.addweightoo
        profileViewModel.newactivity.observe(viewLifecycleOwner, Observer { btn.setOnClickListener { // Launching new Activity on selecting single List Item
            val i = Intent(activity, profile_Add::class.java)
            startActivity(i)
        } })*/


        return root
    }


}