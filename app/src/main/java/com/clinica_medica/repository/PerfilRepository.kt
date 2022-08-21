package com.clinica_medica.repository

import androidx.lifecycle.LiveData
import com.clinica_medica.data.PerfilDao
import com.clinica_medica.model.Perfil

class PerfilRepository(private val perfilDao: PerfilDao) {

    val getAllData: LiveData<List<Perfil>> = perfilDao.getAllData()

    suspend fun addDatosPerfil(perfil: Perfil) {
        perfilDao.addDatosPerfil(perfil)
    }

    suspend fun updatePerfil(perfil: Perfil) {
        perfilDao.updatePerfil(perfil)
    }

    suspend fun deletePerfil(perfil: Perfil) {
        perfilDao.deletePerfil(perfil)
    }

}