package com.example.sunmadinepal.database.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.sunmadinepal.model.DoctorAppointment

//Based on: https://developer.android.com/training/data-storage/room

@Database(entities = [DoctorAppointment::class],version=1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun DoctorAppointmentDao(): DoctorAppointmentDao


    companion object {
        //Based on codelab: https://developer.android.com/codelabs/android-room-with-a-view-kotlin#7
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "App_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}