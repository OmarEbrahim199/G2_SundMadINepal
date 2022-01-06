package com.example.sunmadinepal.framework.db

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


// Based on https://developer.android.com/training/data-storage/room/accessing-data#kotlin

interface DoctorAppointmentDao {
    @Insert
    fun insertAll(vararg doctorAppointments: DoctorAppointment)

    @Delete
    fun delete(doctorAppointment: DoctorAppointment)

    @Query("SELECT * FROM doctorAppointments")
    fun getAll(): List<DoctorAppointment>
}