package com.clinica_medica.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
@Entity(tableName="perfil")

data class Perfil(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    @ColumnInfo(name="nombreUsuario")
    val nombreUsuario:String,
    @ColumnInfo(name="fechaNacimiento")
    val fechaNacimiento:String,
    @ColumnInfo(name="direccion")
    val direccion:String,
    @ColumnInfo(name="peso")
    val peso:Double,
    @ColumnInfo(name="estatura")
    val estatura:Double,
    @ColumnInfo(name="numeroTelefono")
    val numeroTelefono:Int,
    @ColumnInfo(name="correoElectronico")
    val correoElectronico:String,
    @ColumnInfo(name="historial")
    val historial:String,
    @ColumnInfo(name="fechaCita")
    val fechaCita:String
) : Parcelable