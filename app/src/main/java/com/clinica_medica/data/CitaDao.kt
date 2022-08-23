package com.clinica_medica.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.clinica_medica.model.Cita

@Dao
interface CitaDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addDatosCita(cita: Cita)

    @Update (onConflict = OnConflictStrategy.IGNORE)
    suspend fun updateCita(cita: Cita)

    @Delete
    suspend fun deleteCita(cita: Cita)

    @Query ("SELECT * FROM CITA")
    fun getAllData(): LiveData<List<Cita>>
}