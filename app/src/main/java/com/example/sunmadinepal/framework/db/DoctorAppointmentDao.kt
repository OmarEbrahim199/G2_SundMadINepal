package com.example.sunmadinepal.framework.db

import androidx.room.*


// Based on https://developer.android.com/training/data-storage/room/accessing-data#kotlin
@Dao
interface DoctorAppointmentDao {
    @Insert
    fun insertAll(vararg doctorAppointments: DoctorAppointment)

    @Delete
    fun delete(doctorAppointment: DoctorAppointment)

    @Query("SELECT * FROM doctorAppointments")
    fun getAll(): List<DoctorAppointment>

    @Update
    fun updateDoctorAppointments(vararg doctorAppointments: DoctorAppointment)
}