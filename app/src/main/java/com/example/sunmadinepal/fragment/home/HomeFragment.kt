package com.example.sunmadinepal.fragment.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sunmadinepal.databinding.FragmentHomeBinding
import com.example.sunmadinepal.ViewModel.HomeViewModel
import com.example.sunmadinepal.ViewModel.DoctorAppointmentViewModel
import com.example.sunmadinepal.database.local.ListAdapter


class HomeFragment : Fragment() {

    private lateinit var doctorAppointmentViewModel: DoctorAppointmentViewModel
    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val adapter = ListAdapter()
        val recyclerView = binding.recyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        doctorAppointmentViewModel = ViewModelProvider(this).get(DoctorAppointmentViewModel::class.java)
        doctorAppointmentViewModel.readAllData.observe(viewLifecycleOwner, androidx.lifecycle.Observer {doctorAppointment -> adapter.setData(doctorAppointment) })


        return root
    }

    override fun onStart() {
        super.onStart()



    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}