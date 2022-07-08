package com.clinica_medica.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.sql.Date
import java.sql.Time

@Parcelize
@Entity(tableName="expediente")

data class Expediente(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    @ColumnInfo(name="padecimiento")
    val padecimiento:String,
    @ColumnInfo(name="fecha")
    val fecha:Date,
    @ColumnInfo(name="hora")
    val hora:Time,
    @ColumnInfo(name="nombreDoctor")
    val nombreDoctor:String,
    @ColumnInfo(name="medicamentos")
    val medicamentos:String,
    @ColumnInfo(name="Cuidados")
    val Cuidados:String,
) : Parcelable