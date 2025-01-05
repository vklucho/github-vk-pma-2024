package com.example.motivacniaplikace

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

// Definice DAO (Data Access Object) pro práci s entitou Quote
@Dao
interface QuoteDao {

    // SQL dotaz pro získání oblíbených citátů
    @Query("SELECT * FROM quotes WHERE isFavorite = 1")
    suspend fun getFavoriteQuotes(): List<Quote>

    // SQL dotaz pro získání náhodného citátu
    @Query("SELECT * FROM quotes ORDER BY RANDOM() LIMIT 1")
    suspend fun getRandomQuote(): Quote?

    // Metoda pro aktualizaci stavu oblíbených citátů
    @Update
    suspend fun updateFavoriteStatus(quote: Quote)

    // Metoda pro vložení nového citátu do databáze
    @Insert
    suspend fun insertQuote(quote: Quote)
}
