package com.example.motivacniaplikace

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// Definice databáze Room s entitou Quote a verzí databáze 2
@Database(entities = [Quote::class], version = 2)
abstract class AppDatabase : RoomDatabase() {

    // Definuje DAO (Data Access Object) pro citáty
    abstract fun quoteDao(): QuoteDao

    // Kompanion objekt poskytující singleton instanci AppDatabase
    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null

        // Vrátí singleton instanci databáze
        fun getDatabase(context: Context): AppDatabase {
            // Pokud instance neexistuje, vytvoří ji synchronizovaným blokem
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "quote_database"
                )
                    // Povolení destruktivní migrace (v případě změny schématu databáze)
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
