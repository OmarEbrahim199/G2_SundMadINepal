package com.example.sunmadinepal.framework.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
<<<<<<< HEAD
=======
import java.util.*
>>>>>>> origin/Database


@Entity(tableName = "doctorAppointments")
data class DoctorAppointment(
<<<<<<< HEAD
    @PrimaryKey val dId: Int,

    @ColumnInfo(name = "year" ) val year: Int?,
    @ColumnInfo(name = "month" ) val month: Int?,
    @ColumnInfo(name = "day" ) val day: Int?,
    @ColumnInfo(name = "hour" ) val hour: Int?,
    @ColumnInfo(name = "minute" ) val minute: Int?
=======
    @PrimaryKey(autoGenerate = true) val dId: Int,

    @ColumnInfo(name = "date" ) val date: String?,
    /*@ColumnInfo(name = "month" ) val month: Int?,
    @ColumnInfo(name = "day" ) val day: Int?,
    @ColumnInfo(name = "hour" ) val hour: Int?,
    @ColumnInfo(name = "minute" ) val minute: Int?*/
>>>>>>> origin/Database
)
