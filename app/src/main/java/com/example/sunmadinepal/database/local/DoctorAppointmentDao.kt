package com.example.sunmadinepal.database.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.sunmadinepal.model.DoctorAppointment


// Based on https://developer.android.com/training/data-storage/room/accessing-data#kotlin
@Dao
interface DoctorAppointmentDao {

    @Insert
    suspend fun addDoctorAppointment(doctorAppointment: DoctorAppointment)

    @Delete
    suspend fun deleteDoctorAppointment(doctorAppointment: DoctorAppointment)

    @Query("SELECT * FROM doctorAppointments")
    fun readAll(): LiveData<List<DoctorAppointment>>

    @Update
    fun updateDoctorAppointments(vararg doctorAppointments: DoctorAppointment)

}