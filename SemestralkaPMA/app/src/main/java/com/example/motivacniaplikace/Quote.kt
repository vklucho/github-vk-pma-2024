package com.example.motivacniaplikace

import androidx.room.Entity
import androidx.room.PrimaryKey

// Definice entity Quote, která reprezentuje tabulku "quotes" v databázi
@Entity(tableName = "quotes")
data class Quote(
    // Primární klíč s automatickou generací ID
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    // Text citátu
    val text: String,
    // Příznak označující, zda je citát oblíbený
    val isFavorite: Boolean = false
)
