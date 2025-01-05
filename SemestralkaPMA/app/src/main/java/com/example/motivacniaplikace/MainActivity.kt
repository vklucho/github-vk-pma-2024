package com.example.motivacniaplikace

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import androidx.work.PeriodicWorkRequest
import androidx.work.ExistingPeriodicWorkPolicy
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    // Deklarace proměnných pro práci s citáty a uživatelským rozhraním
    private lateinit var quoteDao: QuoteDao
    private lateinit var btnShowQuotes: Button
    private lateinit var tvQuoteOfTheDay: TextView
    private lateinit var btnShowFavorites: Button
    private lateinit var btnTestNotification: Button

    // Metoda onCreate je volána při vytváření aktivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializace proměnných uživatelského rozhraní
        tvQuoteOfTheDay = findViewById(R.id.tvQuoteOfTheDay)
        btnShowQuotes = findViewById(R.id.btnShowQuotes)
        btnShowFavorites = findViewById(R.id.btnShowFavorites)
        btnTestNotification = findViewById(R.id.btnTestNotification)

        // Získání instance QuoteDao pro přístup k databázi citátů
        quoteDao = AppDatabase.getDatabase(this).quoteDao()

        // Inicializace citátů v databázi
        initializeQuotes()

        // Zobrazení citátu dne
        getQuoteOfTheDay()

        // Nastavení tlačítek pro zobrazení citátů, oblíbených citátů a testování notifikací
        btnShowQuotes.setOnClickListener {
            val intent = Intent(this, QuotesActivity::class.java)
            startActivity(intent)
        }

        btnShowFavorites.setOnClickListener {
            val intent = Intent(this, FavoritesActivity::class.java)
            startActivity(intent)
        }

        btnTestNotification.setOnClickListener {
            scheduleTestNotification()
        }

        // Kontrola a žádost o oprávnění pro notifikace
        checkAndRequestNotificationPermission()

        // Naplánování denní notifikace na 10:00
        scheduleDailyNotification()
    }

    // Metoda pro naplánování jednorázové testovací notifikace
    private fun scheduleTestNotification() {
        val workRequest = OneTimeWorkRequest.Builder(NotificationWorker::class.java).build()
        WorkManager.getInstance(this).enqueue(workRequest)
    }

    // Metoda pro získání a zobrazení citátu dne
    private fun getQuoteOfTheDay() {
        lifecycleScope.launch {
            val sharedPreferences = getSharedPreferences("QuoteAppPrefs", Context.MODE_PRIVATE)
            val lastUpdateTime = sharedPreferences.getLong("lastUpdateTime", 0)
            val currentTime = System.currentTimeMillis()

            if (isSameDay(lastUpdateTime, currentTime)) {
                // Načtení citátu dne z SharedPreferences
                val quoteText = sharedPreferences.getString("quoteOfTheDay", "Žádný citát dne není k dispozici.")
                tvQuoteOfTheDay.text = quoteText
            } else {
                try {
                    val quote = quoteDao.getRandomQuote()
                    quote?.let {
                        // Uložení citátu dne a času aktualizace do SharedPreferences
                        sharedPreferences.edit()
                            .putString("quoteOfTheDay", it.text)
                            .putLong("lastUpdateTime", currentTime)
                            .apply()
                        tvQuoteOfTheDay.text = it.text
                    } ?: run {
                        tvQuoteOfTheDay.text = "Žádný citát dne není k dispozici."
                    }
                } catch (e: Exception) {
                    tvQuoteOfTheDay.text = "Nepodařilo se načíst citát dne."
                }
            }
        }
    }

    // Metoda pro kontrolu, zda jsou dva časové údaje ve stejný den
    private fun isSameDay(time1: Long, time2: Long): Boolean {
        val calendar1 = Calendar.getInstance().apply { timeInMillis = time1 }
        val calendar2 = Calendar.getInstance().apply { timeInMillis = time2 }
        return calendar1.get(Calendar.YEAR) == calendar2.get(Calendar.YEAR) &&
                calendar1.get(Calendar.DAY_OF_YEAR) == calendar2.get(Calendar.DAY_OF_YEAR)
    }

    // Metoda pro inicializaci citátů v databázi
    private fun initializeQuotes() {
        lifecycleScope.launch {
            val initialQuotes = listOf(
                Quote(text = "Věřte, že můžete a jste na půli cesty."),
                Quote(text = "Každý den je nová příležitost."),
                Quote(text = "Život je to, co z něj uděláte."),
                Quote(text = "Nikdy není pozdě být tím, kým jste mohli být."),
                Quote(text = "Nezáleží na tom, jak pomalu jdete, pokud nezastavíte."),
                Quote(text = "Každý okamžik je nový začátek."),
                Quote(text = "Nečekejte na příležitosti, vytvářejte je."),
                Quote(text = "Vaše omezení jsou jen ve vaší mysli."),
                Quote(text = "Nikdy se nevzdávejte svých snů."),
                Quote(text = "Úspěch je směs odvahy, úsilí a víry."),
                Quote(text = "Dnes je den, kdy začnete plnit své sny."),
                Quote(text = "Žijte každý den, jako by byl váš poslední."),
                Quote(text = "Dělejte to, co máte rádi, a nepracujte jediný den ve svém životě."),
                Quote(text = "Síla spočívá v odvaze jít dál."),
                Quote(text = "Nikdy nepodceňujte svou schopnost změnit svůj život."),
                Quote(text = "Jste schopni všeho, na co zaměříte svou mysl."),
                Quote(text = "Vaše budoucnost závisí na tom, co děláte dnes."),
                Quote(text = "Každý den je šance stát se lepší verzí sebe sama."),
                Quote(text = "Odvaha není nepřítomnost strachu, ale vítězství nad ním."),
                Quote(text = "Nevzdávejte se, každý úspěch začíná rozhodnutím to zkusit.")
            )

            initialQuotes.forEach { quoteDao.insertQuote(it) }
        }
    }

    // Metoda pro kontrolu a žádost o oprávnění pro notifikace
    private fun checkAndRequestNotificationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            val permission = "android.permission.POST_NOTIFICATIONS"
            if (ContextCompat.checkSelfPermission(
                    this,
                    permission
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(this, arrayOf(permission), 1001)
            }
        }
    }

    // Metoda pro naplánování denní notifikace
    private fun scheduleDailyNotification() {
        val workRequest =
            PeriodicWorkRequest.Builder(NotificationWorker::class.java, 1, TimeUnit.DAYS)
                .setInitialDelay(calculateInitialDelay(), TimeUnit.MILLISECONDS)
                .build()
        WorkManager.getInstance(this).enqueueUniquePeriodicWork(
            "DailyNotification",
            ExistingPeriodicWorkPolicy.REPLACE,
            workRequest
        )
    }

    // Metoda pro výpočet zpoždění do příštího spuštění notifikace (na 10:00)
    private fun calculateInitialDelay(): Long {
        val currentTime = System.currentTimeMillis()
        val nextTriggerTime = Calendar.getInstance().apply {
            if (get(Calendar.HOUR_OF_DAY) >= 10) {
                add(Calendar.DAY_OF_MONTH, 1)
            }
            set(Calendar.HOUR_OF_DAY, 10)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
        }.timeInMillis
        return nextTriggerTime - currentTime
    }
}
