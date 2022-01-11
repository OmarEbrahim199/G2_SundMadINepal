package com.example.sunmadinepal.framework.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "doctorAppointments")
data class DoctorAppointment(
    @PrimaryKey val dId: Int,

    @ColumnInfo(name = "year" ) val year: Int?,
    @ColumnInfo(name = "month" ) val month: Int?,
    @ColumnInfo(name = "day" ) val day: Int?,
    @ColumnInfo(name = "hour" ) val hour: Int?,
    @ColumnInfo(name = "minute" ) val minute: Int?
)
