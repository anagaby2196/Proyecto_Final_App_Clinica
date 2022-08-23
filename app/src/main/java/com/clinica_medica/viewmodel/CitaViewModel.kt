package com.clinica_medica.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.clinica_medica.data.CitaDatabase
import com.clinica_medica.model.Cita
import com.clinica_medica.repository.CitaRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CitaViewModel(application: Application) : AndroidViewModel(application) {

    val getAllData: LiveData<List<Cita>>

    private val repository: CitaRepository

    init {
        val citaDao = CitaDatabase.getDatabase(application).citaDao()
        repository = CitaRepository(citaDao)
        getAllData = repository.getAllData
    }

    fun addDatosCita(cita: Cita) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addDatosCita(cita)
        }
    }

    fun updateCita(cita: Cita) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateCita(cita)
        }
    }

    fun deleteCita (cita: Cita) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteCita(cita)
        }
    }

}