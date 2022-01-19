package com.example.sunmadinepal.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "doctorAppointments")
data class DoctorAppointment(
    @PrimaryKey(autoGenerate = true) val dId: Int,

    @ColumnInfo(name = "date" ) val date: String?,

)
