package com.example.sunmadinepal.framework.db

import androidx.room.Database
import androidx.room.RoomDatabase


//Based on: https://developer.android.com/training/data-storage/room

@Database(entities = [DoctorAppointment::class],version=1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun DoctorAppointmentDao(): DoctorAppointmentDao
}