package com.clinica_medica.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.clinica_medica.model.Promocion

@Database(entities = [Promocion::class], version = 1, exportSchema = false)

abstract class PromocionDatabase : RoomDatabase() {
    abstract fun promocionDao() : PromocionDao

    companion object {
        @Volatile
        private var INSTANCE: PromocionDatabase? = null

        fun getDatabase(context: android.content.Context) : PromocionDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PromocionDatabase::class.java,
                    "promocion_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}