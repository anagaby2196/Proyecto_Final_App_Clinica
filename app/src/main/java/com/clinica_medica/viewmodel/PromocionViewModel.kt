package com.clinica_medica.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.clinica_medica.data.PromocionDatabase
import com.clinica_medica.model.Promocion
import com.clinica_medica.repository.PromocionRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PromocionViewModel(application: Application) : AndroidViewModel(application) {

    val getAllData: LiveData<List<Promocion>>

    private val repository: PromocionRepository

    init {
        val promocionDao = PromocionDatabase.getDatabase(application).promocionDao()
        repository = PromocionRepository(promocionDao)
        getAllData = repository.getAllData
    }

    fun addPromocion (promocion: Promocion) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addPromocion(promocion)
        }
    }

    fun updatePromocion (promocion: Promocion) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updatePromocion(promocion)
        }
    }

    fun deletePromocion (promocion: Promocion) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deletePromocion(promocion)
        }
    }
}