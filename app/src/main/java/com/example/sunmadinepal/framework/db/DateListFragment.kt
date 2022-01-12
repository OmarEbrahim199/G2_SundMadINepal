package com.example.sunmadinepal.framework.db

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sunmadinepal.R
import com.example.sunmadinepal.databinding.FragmentDateListBinding
import com.example.sunmadinepal.databinding.FragmentProfileBinding

class DateListFragment : Fragment() {

    private lateinit var doctorAppointmentViewModel: DoctorAppointmentViewModel
    private var _binding: FragmentDateListBinding? = null

    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDateListBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val adapter = ListAdapter()
        val recyclerView = binding.recyclerView2
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        doctorAppointmentViewModel = ViewModelProvider(this).get(DoctorAppointmentViewModel::class.java)
        doctorAppointmentViewModel.readAllData.observe(viewLifecycleOwner, androidx.lifecycle.Observer {doctorAppointment -> adapter.setData(doctorAppointment) })



        return root
    }


}