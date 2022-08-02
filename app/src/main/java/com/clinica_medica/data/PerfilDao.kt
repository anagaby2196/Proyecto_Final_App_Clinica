package com.clinica_medica.data

import android.database.sqlite.SQLiteDatabase
import androidx.lifecycle.LiveData
import androidx.room.*
import com.clinica_medica.model.Perfil


@Dao
interface PerfilDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addDatosPerfil(perfil: Perfil)

    @Update (onConflict = OnConflictStrategy.IGNORE)
    suspend fun updatePerfil(perfil: Perfil)

    @Delete
    suspend fun deletePerfil(perfil: Perfil)

    @Query ("SELECT * FROM PERFIL WHERE ID=1")
    fun getAllData(): LiveData<List<Perfil>>


}