package com.example.sunmadinepal.framework.db

import androidx.lifecycle.LiveData
import androidx.room.*
<<<<<<< HEAD
=======
import java.util.*
>>>>>>> origin/Database
import java.util.concurrent.Flow


// Based on https://developer.android.com/training/data-storage/room/accessing-data#kotlin
@Dao
interface DoctorAppointmentDao {
    @Insert
    fun insertAll(vararg doctorAppointments: DoctorAppointment)

<<<<<<< HEAD
=======
    @Insert
    suspend fun addDoctorAppointment(doctorAppointment: DoctorAppointment)

>>>>>>> origin/Database
    @Delete
    fun delete(doctorAppointment: DoctorAppointment)

    @Query("SELECT * FROM doctorAppointments")
    fun readAll(): LiveData<List<DoctorAppointment>>

    @Update
    fun updateDoctorAppointments(vararg doctorAppointments: DoctorAppointment)

}