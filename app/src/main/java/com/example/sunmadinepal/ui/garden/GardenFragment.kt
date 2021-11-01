package com.example.sunmadinepal.ui.garden

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.Observer

import com.example.sunmadinepal.databinding.FragmentGardenBinding

class GardenFragment : Fragment(){
 private lateinit var GardenViewModel : GardenViewModel
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
   ViewModelProvider(this).get(com.example.sunmadinepal.ui.garden.GardenViewModel::class.java)

  _binding = FragmentGardenBinding.inflate(inflater, container, false)
  val root: View = binding.root

  val textView: TextView = binding.textGarden
  GardenViewModel.text.observe(viewLifecycleOwner, Observer {
   textView.text = it
  })
  return root
 }

 override fun onDestroyView() {
  super.onDestroyView()
  _binding = null
 }



}
