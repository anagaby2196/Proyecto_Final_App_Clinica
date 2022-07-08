package com.clinica_medica.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName="promocion")

data class Promocion(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    @ColumnInfo(name="nombrePromocion")
    val nombrePromocion:String,
    @ColumnInfo(name="descripcion")
    val descripcion:String,
    @ColumnInfo(name="descuento")
    val descuento:Int
) : Parcelable