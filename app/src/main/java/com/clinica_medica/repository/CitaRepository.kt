package com.clinica_medica.repository

import androidx.lifecycle.LiveData
import com.clinica_medica.data.CitaDao
import com.clinica_medica.model.Cita

class CitaRepository(private val citaDao: CitaDao) {

    val getAllData: LiveData<List<Cita>> = citaDao.getAllData()

    suspend fun addDatosCita(cita: Cita) {
        citaDao.addDatosCita(cita)
    }

    suspend fun updateCita(cita: Cita) {
        citaDao.updateCita(cita)
    }

    suspend fun deleteCita(cita: Cita) {
        citaDao.deleteCita(cita)
    }

}