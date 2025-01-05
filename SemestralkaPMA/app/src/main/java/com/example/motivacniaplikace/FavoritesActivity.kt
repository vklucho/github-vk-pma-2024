package com.example.motivacniaplikace

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch

class FavoritesActivity : AppCompatActivity() {

    // Deklarace proměnných pro práci s citáty a uživatelským rozhraním
    private lateinit var quoteDao: QuoteDao
    private lateinit var rvFavorites: RecyclerView
    private lateinit var btnBackToMain: Button

    // Metoda onCreate je volána při vytváření aktivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)

        // Inicializace proměnných uživatelského rozhraní
        rvFavorites = findViewById(R.id.rvFavorites)
        rvFavorites.layoutManager = LinearLayoutManager(this)
        btnBackToMain = findViewById(R.id.btnBackToMain)

        // Získání instance QuoteDao pro přístup k databázi citátů
        quoteDao = AppDatabase.getDatabase(this).quoteDao()

        // Načtení oblíbených citátů
        loadFavorites()

        // Nastavení tlačítka pro návrat na hlavní obrazovku
        btnBackToMain.setOnClickListener {
            finish()
        }
    }

    // Metoda pro načtení oblíbených citátů z databáze
    private fun loadFavorites() {
        lifecycleScope.launch {
            // Získání oblíbených citátů z databáze
            val favoriteQuotes = quoteDao.getFavoriteQuotes()
            if (favoriteQuotes.isNotEmpty()) {
                // Nastavení adapteru pro RecyclerView s oblíbenými citáty
                rvFavorites.adapter = RecyclerViewAdapter(favoriteQuotes) { quote ->
                    // Aktualizace stavu oblíbených citátů
                    lifecycleScope.launch {
                        val updatedQuote = quote.copy(isFavorite = false)
                        quoteDao.updateFavoriteStatus(updatedQuote)
                        Toast.makeText(this@FavoritesActivity, "Citát byl odstraněn z oblíbených", Toast.LENGTH_SHORT).show()
                        loadFavorites() // Aktualizace seznamu oblíbených citátů
                    }
                }
            } else {
                // Zobrazení zprávy, pokud nejsou k dispozici žádné oblíbené citáty
                Toast.makeText(this@FavoritesActivity, "Žádné oblíbené citáty nejsou k dispozici", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
