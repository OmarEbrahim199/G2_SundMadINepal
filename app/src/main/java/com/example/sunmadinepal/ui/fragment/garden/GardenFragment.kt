package com.example.sunmadinepal.ui.fragment.garden

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

import com.example.sunmadinepal.databinding.FragmentGardenBinding
import com.example.sunmadinepal.ui.ViewModel.GardenViewModel


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
   ViewModelProvider(this).get(com.example.sunmadinepal.ui.ViewModel.GardenViewModel::class.java)

  _binding = FragmentGardenBinding.inflate(inflater, container, false)
  val root: View = binding.root
  return root

 }

 override fun onDestroyView() {
  super.onDestroyView()
  _binding = null
 }

 override fun onStart() {
  super.onStart()
 }

}
