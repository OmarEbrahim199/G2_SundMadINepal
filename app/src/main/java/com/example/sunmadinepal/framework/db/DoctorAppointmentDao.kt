package com.example.sunmadinepal.framework.db

import androidx.lifecycle.LiveData
import androidx.room.*
import java.util.*
import java.util.concurrent.Flow


// Based on https://developer.android.com/training/data-storage/room/accessing-data#kotlin
@Dao
interface DoctorAppointmentDao {
    @Insert
    fun insertAll(vararg doctorAppointments: DoctorAppointment)

    @Insert
    suspend fun addDoctorAppointment(doctorAppointment: DoctorAppointment)

    @Delete
    fun delete(doctorAppointment: DoctorAppointment)

    @Query("SELECT * FROM doctorAppointments")
    fun readAll(): LiveData<List<DoctorAppointment>>

    @Update
    fun updateDoctorAppointments(vararg doctorAppointments: DoctorAppointment)

}