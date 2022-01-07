package com.example.sunmadinepal.fragment.Profile

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room

import com.example.sunmadinepal.databinding.FragmentProfileBinding
import com.example.sunmadinepal.ViewModel.ProfileViewModel
import com.example.sunmadinepal.framework.db.AppDatabase
import com.example.sunmadinepal.framework.db.DoctorAppointment
import com.example.sunmadinepal.framework.db.DoctorAppointmentDao
import com.example.sunmadinepal.framework.db.DoctorAppointmentViewModel
import java.util.*

class ProfileFragment : Fragment() {

// Based on https://www.youtube.com/watch?v=UBCAWfztTrQ

    private lateinit var profileViewModel: ProfileViewModel
    private var _binding:FragmentProfileBinding ? = null
    private lateinit var doctorAppointmentViewModel: DoctorAppointmentViewModel

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root

        doctorAppointmentViewModel = ViewModelProvider(this).get(DoctorAppointmentViewModel::class.java)

        val date = Calendar.getInstance()
        val year = date.get(Calendar.YEAR)
        val month = date.get(Calendar.MONTH)
        val day = date.get(Calendar.DAY_OF_MONTH)


        binding.addAppointment.setOnClickListener { val datePickerDialog = DatePickerDialog(requireContext(), { view, savedYear, savedMonth, savedDay ->
            binding.dateBox.setText(""+ savedDay +"-"+ (savedMonth+1) +"-"+ savedYear)
        }, year, month, day)

            datePickerDialog.show()

        }

        binding.saveDate.setOnClickListener {
            insertDataToDatabase()
        }



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

    private fun insertDataToDatabase() {
        val dateToDatabase = binding.dateBox.text

        val doctorAppointment = DoctorAppointment(0,Integer.parseInt(dateToDatabase.toString()))

        doctorAppointmentViewModel.addDoctorAppointment(doctorAppointment)
        Toast.makeText(requireContext(),"Date saved", Toast.LENGTH_LONG).show()
    }


}