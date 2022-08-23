package com.clinica_medica.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName="cita")

data class Cita(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    @ColumnInfo(name="nombrePaciente")
    val nombrePaciente:String,
    @ColumnInfo(name="padecimiento")
    val padecimiento:String,
    @ColumnInfo(name="dia")
    val dia:String,
    @ColumnInfo(name="fecha")
    val fecha:String,
    @ColumnInfo(name="hora")
    val hora:String,
    @ColumnInfo(name="nombreDoctor")
    val nombreDoctor:String
) : Parcelable