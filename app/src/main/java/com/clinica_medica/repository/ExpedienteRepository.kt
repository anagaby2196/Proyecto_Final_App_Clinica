package com.clinica_medica.repository

import androidx.lifecycle.LiveData
import com.clinica_medica.data.ExpedienteDao
import com.clinica_medica.model.Expediente

class ExpedienteRepository(private val expedienteDao: ExpedienteDao) {

    val getAllData: LiveData<List<Expediente>> = expedienteDao.getAllData()

    suspend fun addDatosExpediente(expediente: Expediente) {
        expedienteDao.addDatosExpediente(expediente)
    }

    suspend fun updateExpediente(expediente: Expediente) {
        expedienteDao.updateExpediente(expediente)
    }

    suspend fun deleteExpediente(expediente: Expediente) {
        expedienteDao.deleteExpediente(expediente)
    }

}