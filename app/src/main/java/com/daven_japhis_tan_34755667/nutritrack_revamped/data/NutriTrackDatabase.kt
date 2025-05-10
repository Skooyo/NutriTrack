package com.daven_japhis_tan_34755667.nutritrack_revamped.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.daven_japhis_tan_34755667.nutritrack_revamped.data.entities.Patient
import com.daven_japhis_tan_34755667.nutritrack_revamped.data.dao.PatientDao

// TODO: add entities
@Database(entities = [Patient::class], version = 1, exportSchema = false)
abstract class NutriTrackDatabase: RoomDatabase() {
    abstract fun patientDao(): PatientDao

    //TODO: make a DAO for the entities in NutriTrack
    // abstract fun patientDao(): PatientDao

    companion object {
        @Volatile
        private var Instance: NutriTrackDatabase? = null

        fun getDatabase(context: Context): NutriTrackDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, NutriTrackDatabase::class.java, "nutritrack_database")
                    .build().also { Instance = it }
            }
        }
    }

}