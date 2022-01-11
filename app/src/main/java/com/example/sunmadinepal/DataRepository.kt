package com.example.sunmadinepal

import androidx.lifecycle.LiveData
import com.example.sunmadinepal.framework.db.DoctorAppointment
import com.example.sunmadinepal.framework.db.DoctorAppointmentDao

<<<<<<< HEAD
=======
//Based on https://www.youtube.com/watch?v=UBCAWfztTrQ

>>>>>>> origin/Database
class DataRepository(private val doctorAppointmentDao: DoctorAppointmentDao) {

    val readAllData: LiveData<List<DoctorAppointment>> = doctorAppointmentDao.readAll()

<<<<<<< HEAD
=======
    suspend fun addDoctorAppointment(doctorAppointment: DoctorAppointment) {
        doctorAppointmentDao.addDoctorAppointment(doctorAppointment)
    }

>>>>>>> origin/Database
}