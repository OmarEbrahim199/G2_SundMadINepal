package com.example.sunmadinepal.framework.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@Entity(tableName = "doctorAppointments")
data class DoctorAppointment(
    @PrimaryKey(autoGenerate = true) val dId: Int,

    @ColumnInfo(name = "date" ) val date: String?,

)
