package com.clinica_medica.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.clinica_medica.data.PerfilDatabase
import com.clinica_medica.model.Perfil
import com.clinica_medica.repository.PerfilRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PerfilViewModel(application: Application) : AndroidViewModel(application) {

    val getAllData: LiveData<List<Perfil>>

    private val repository: PerfilRepository

    init {
        val perfilDao = PerfilDatabase.getDatabase(application).perfilDao()
        repository = PerfilRepository(perfilDao)
        getAllData = repository.getAllData
    }

    fun addDatosPerfil(perfil: Perfil) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addDatosPerfil(perfil)
        }
    }

    fun updatePerfil(perfil: Perfil) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updatePerfil(perfil)
        }
    }

    fun deletePerfil (perfil: Perfil) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deletePerfil(perfil)
        }
    }

}
