package com.clinica_medica.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.clinica_medica.model.Expediente

@Dao
interface ExpedienteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addDatosExpediente(expediente: Expediente)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun updateExpediente(expediente: Expediente)

    @Delete
    suspend fun deleteExpediente(expediente: Expediente)

    @Query("SELECT * FROM EXPEDIENTE")
    fun getAllData(): LiveData<List<Expediente>>
}