package com.clinica_medica.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName="expediente")

data class Expediente(
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
    val nombreDoctor:String,
    @ColumnInfo(name="medicamentos")
    val medicamentos:String,
    @ColumnInfo(name="cuidados")
    val cuidados:String,
) : Parcelable