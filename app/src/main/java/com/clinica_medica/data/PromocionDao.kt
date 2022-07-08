package com.clinica_medica.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.clinica_medica.model.Promocion

@Dao
interface PromocionDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addPromocion(promocion: Promocion)

    @Update (onConflict = OnConflictStrategy.IGNORE)
    suspend fun updatePromocion(promocion: Promocion)

    @Delete
    suspend fun deletePromocion(promocion: Promocion)

    @Query ("SELECT * FROM PROMOCION")
    fun getAllData(): LiveData<List<Promocion>>
}