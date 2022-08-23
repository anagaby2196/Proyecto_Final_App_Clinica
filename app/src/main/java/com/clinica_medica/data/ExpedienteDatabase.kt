package com.clinica_medica.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.clinica_medica.model.Expediente

@Database(entities = [Expediente::class], version = 1, exportSchema = false)

abstract class ExpedienteDatabase : RoomDatabase() {
    abstract fun expedienteDao(): ExpedienteDao

    companion object {
        @Volatile
        private var INSTANCE: ExpedienteDatabase? = null

        fun getDatabase(context: android.content.Context): ExpedienteDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ExpedienteDatabase::class.java,
                    "expediente_database"
                ).build()
                INSTANCE = instance
                return instance
            }

            }
        }
}
