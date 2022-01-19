package com.example.sunmadinepal

import androidx.lifecycle.LiveData
import com.example.sunmadinepal.model.DoctorAppointment
import com.example.sunmadinepal.database.local.DoctorAppointmentDao

//Based on https://www.youtube.com/watch?v=UBCAWfztTrQ


class DataRepository(private val doctorAppointmentDao: DoctorAppointmentDao) {

    val readAllData: LiveData<List<DoctorAppointment>> = doctorAppointmentDao.readAll()

    suspend fun addDoctorAppointment(doctorAppointment: DoctorAppointment) {
        doctorAppointmentDao.addDoctorAppointment(doctorAppointment)
    }

    suspend fun deleteDoctorAppointment(doctorAppointment: DoctorAppointment) {
        doctorAppointmentDao.deleteDoctorAppointment(doctorAppointment)
    }

}