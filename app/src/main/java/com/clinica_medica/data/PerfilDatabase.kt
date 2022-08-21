package com.clinica_medica.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.clinica_medica.model.Perfil


@Database(entities = [Perfil::class], version = 1, exportSchema = false)

abstract class PerfilDatabase : RoomDatabase() {
    abstract fun perfilDao(): PerfilDao

    companion object {
        @Volatile
        private var INSTANCE: PerfilDatabase? = null

        fun getDatabase(context: android.content.Context): PerfilDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PerfilDatabase::class.java,
                    "perfil_database"
                ).build()
                INSTANCE = instance
                return instance
            }

            }
        }
}
