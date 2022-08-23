package com.clinica_medica.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.clinica_medica.data.ExpedienteDatabase
import com.clinica_medica.model.Expediente
import com.clinica_medica.repository.ExpedienteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ExpedienteViewModel(application: Application) : AndroidViewModel(application) {

    val getAllData: LiveData<List<Expediente>>

    private val repository: ExpedienteRepository

    init {
        val expedienteDao = ExpedienteDatabase.getDatabase(application).expedienteDao()
        repository = ExpedienteRepository(expedienteDao)
        getAllData = repository.getAllData
    }

    fun addDatosExpediente(expediente: Expediente) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addDatosExpediente(expediente)
        }
    }

    fun updateExpediente(expediente: Expediente) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateExpediente(expediente)
        }
    }

    fun deleteExpediente (expediente: Expediente) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteExpediente(expediente)
        }
    }

}