package com.clinica_medica.repository

import androidx.lifecycle.LiveData
import com.clinica_medica.data.ServicioDao
import com.clinica_medica.model.Servicio

class ServicioRepository(private val servicioDao: ServicioDao) {

    val getAllData: LiveData<List<Servicio>> = servicioDao.getAllData()

    suspend fun addServicio(servicio: Servicio) {
        servicioDao.addServicio(servicio)
    }

    suspend fun updateServicio(servicio: Servicio) {
        servicioDao.updateServicio(servicio)
    }

    suspend fun deleteServicio(servicio: Servicio) {
        servicioDao.deleteServicio(servicio)
    }
}