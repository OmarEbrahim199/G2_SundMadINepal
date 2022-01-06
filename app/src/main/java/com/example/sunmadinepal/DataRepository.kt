package com.example.sunmadinepal

import androidx.lifecycle.LiveData
import com.example.sunmadinepal.framework.db.DoctorAppointment
import com.example.sunmadinepal.framework.db.DoctorAppointmentDao

class DataRepository(private val doctorAppointmentDao: DoctorAppointmentDao) {

    val readAllData: LiveData<List<DoctorAppointment>> = doctorAppointmentDao.readAll()

}