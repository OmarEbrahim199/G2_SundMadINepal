package com.example.sunmadinepal.framework.db

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.sunmadinepal.DataRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


//Based on https://www.youtube.com/watch?v=lwAvI3WDXBY
class DoctorAppointmentViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<DoctorAppointment>>
    private val repository: DataRepository


    init {
        val doctorAppointmentDao = AppDatabase.getDatabase(application).DoctorAppointmentDao()
        repository = DataRepository(doctorAppointmentDao)
        readAllData = repository.readAllData
    }

    fun addDoctorAppointment(doctorAppointment: DoctorAppointment){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addDoctorAppointment(doctorAppointment)
        }
    }


}