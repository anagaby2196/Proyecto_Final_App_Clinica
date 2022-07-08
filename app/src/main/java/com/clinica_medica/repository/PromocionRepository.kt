package com.clinica_medica.repository

import androidx.lifecycle.LiveData
import com.clinica_medica.data.PromocionDao
import com.clinica_medica.model.Promocion

class PromocionRepository(private val promocionDao: PromocionDao) {

    val getAllData: LiveData<List<Promocion>> = promocionDao.getAllData()

    suspend fun addPromocion(promocion: Promocion) {
        promocionDao.addPromocion(promocion)
    }

    suspend fun updatePromocion(promocion: Promocion) {
        promocionDao.updatePromocion(promocion)
    }

    suspend fun deletePromocion(promocion: Promocion) {
        promocionDao.deletePromocion(promocion)
    }
}