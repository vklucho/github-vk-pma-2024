package com.example.motivacniaplikace

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class QuotesActivity : AppCompatActivity() {

    // Deklarace proměnných pro práci s citáty a uživatelským rozhraním
    private lateinit var quoteDao: QuoteDao
    private lateinit var tvQuote: TextView
    private lateinit var btnNewQuote: Button
    private lateinit var btnFavorite: Button
    private lateinit var btnBack: Button
    private var currentQuote: Quote? = null

    // Metoda onCreate je volána při vytváření aktivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)

        // Inicializace proměnných uživatelského rozhraní
        tvQuote = findViewById(R.id.tvQuote)
        btnNewQuote = findViewById(R.id.btnNewQuote)
        btnFavorite = findViewById(R.id.btnFavorite)
        btnBack = findViewById(R.id.btnBack)

        // Získání instance QuoteDao pro přístup k databázi citátů
        quoteDao = AppDatabase.getDatabase(this).quoteDao()

        // Načtení náhodného citátu při spuštění aktivity
        loadRandomQuote()

        // Nastavení tlačítka pro načtení nového náhodného citátu
        btnNewQuote.setOnClickListener {
            loadRandomQuote()
        }

        // Nastavení tlačítka pro přidání nebo odebrání citátu z oblíbených
        btnFavorite.setOnClickListener {
            currentQuote?.let { quote ->
                lifecycleScope.launch {
                    val updatedQuote = quote.copy(isFavorite = !quote.isFavorite)
                    quoteDao.updateFavoriteStatus(updatedQuote)
                    val message = if (updatedQuote.isFavorite) "Citát byl přidán do oblíbených" else "Citát byl odstraněn z oblíbených"
                    Toast.makeText(this@QuotesActivity, message, Toast.LENGTH_SHORT).show()
                }
            }
        }

        // Nastavení tlačítka pro návrat na předchozí obrazovku
        btnBack.setOnClickListener {
            finish()
        }
    }

    // Metoda pro načtení náhodného citátu z databáze
    private fun loadRandomQuote() {
        lifecycleScope.launch {
            val randomQuote = quoteDao.getRandomQuote()
            currentQuote = randomQuote
            tvQuote.text = randomQuote?.text ?: "Žádný náhodný citát není k dispozici"
        }
    }
}
