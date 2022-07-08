package com.clinica_medica.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.clinica_medica.data.ServicioDatabase
import com.clinica_medica.model.Servicio
import com.clinica_medica.repository.ServicioRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ServicioViewModel(application: Application) : AndroidViewModel(application) {

    val getAllData: LiveData<List<Servicio>>

    private val repository: ServicioRepository

    init {
        val servicioDao = ServicioDatabase.getDatabase(application).servicioDao()
        repository = ServicioRepository(servicioDao)
        getAllData = repository.getAllData
    }

    fun addServicio (servicio: Servicio) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addServicio(servicio)
        }
    }

    fun updateServicio (servicio: Servicio) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateServicio(servicio)
        }
    }

    fun deleteServicio (servicio: Servicio) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteServicio(servicio)
        }
    }
}