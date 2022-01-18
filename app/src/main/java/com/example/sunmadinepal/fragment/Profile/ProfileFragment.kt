package com.example.sunmadinepal.fragment.Profile

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.sunmadinepal.R

import com.example.sunmadinepal.databinding.FragmentProfileBinding
import com.example.sunmadinepal.ViewModel.ProfileViewModel
import com.example.sunmadinepal.framework.db.*
import java.util.*

class ProfileFragment : Fragment() {

// Based on https://www.youtube.com/watch?v=UBCAWfztTrQ

    private var _binding: FragmentProfileBinding ? = null
    private lateinit var doctorAppointmentViewModel: DoctorAppointmentViewModel

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root

        doctorAppointmentViewModel = ViewModelProvider(this).get(DoctorAppointmentViewModel::class.java)

        binding.addAppointment.setOnClickListener {
            pickDateTime()


            binding.saveDate.setOnClickListener {
                insertDataToDatabase()
            }


            //Based on https://www.youtube.com/watch?v=3USvr1Lz8g8&t=49s
            val adapter = ListAdapter()
            val recyclerView = binding.recyclerview1
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(requireContext())

            doctorAppointmentViewModel.readAllData.observe(viewLifecycleOwner, androidx.lifecycle.Observer {doctorAppointment -> adapter.setData(doctorAppointment) })

        }
        return root
    }



    //pickDateTime() based on: https://stackoverflow.com/questions/38604157/android-date-time-picker-in-one-dialog
    fun pickDateTime() {
        val currentDateTime = Calendar.getInstance()
        val startYear = currentDateTime.get(Calendar.YEAR)
        val startMonth = currentDateTime.get(Calendar.MONTH)
        val startDay = currentDateTime.get(Calendar.DAY_OF_MONTH)
        val startHour = currentDateTime.get(Calendar.HOUR_OF_DAY)
        val startMinute = currentDateTime.get(Calendar.MINUTE)
        DatePickerDialog(requireContext(), R.style.DatePickerDialogTheme, DatePickerDialog.OnDateSetListener { _, year, month, day ->
            TimePickerDialog(requireContext(), R.style.DatePickerDialogTheme, TimePickerDialog.OnTimeSetListener { _, hour, minute ->
                val pickedDateTime = Calendar.getInstance()
                pickedDateTime.set(year, month, day, hour, minute)
                binding.dateBox.setText(""+timeFormat(hour)+":"+timeFormat(minute) +"    " +day +"/"+ (month+1) +"/"+ year)
            }, startHour, startMinute, true).show()
        }, startYear, startMonth, startDay).show()
    }

    fun timeFormat(number: Int): String? {
        return if (number <= 9) "0$number" else number.toString()
    }

    private fun insertDataToDatabase() {
        val dateToDatabase = binding.dateBox.text.toString()

        val doctorAppointment = DoctorAppointment(0,dateToDatabase)

        doctorAppointmentViewModel.addDoctorAppointment(doctorAppointment)
        Toast.makeText(requireContext(),"Date saved", Toast.LENGTH_LONG).show()
    }


}


