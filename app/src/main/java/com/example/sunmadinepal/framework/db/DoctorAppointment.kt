package com.example.sunmadinepal.framework.db

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "doctorAppointments")
data class DoctorAppointment(
    @PrimaryKey val dId: Int,

    val year: Int?,
    val month: Int?,
    val day: Int?,
    val hour: Int?,
    val minute: Int?
)
