package com.example.myapp004objednavka

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import com.example.myapp004objednavka.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        //binding settings
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Objednávka vozidla"

        // Zobrazení Toastu při změně vybraného RadioButton
        binding.rgCar.setOnCheckedChangeListener { _, checkedId ->
            val selectedRadioButton = findViewById<RadioButton>(checkedId)
            val selectedText = selectedRadioButton.text.toString()

            // Vytvoření Toastu
            Toast.makeText(this, "Vybrali jste: $selectedText", Toast.LENGTH_SHORT).show()

            binding.btnSend.setOnClickListener {
                //načtení ID vybraného radiobuttonu z radiogroup
                val carRbId = binding.rgCar.checkedRadioButtonId
                val car = findViewById<RadioButton>(carRbId)

                val prevodovka = binding.cbPrevodovka.isChecked
                val volant = binding.cbVolant.isChecked
                val strecha = binding.cbStrecha.isChecked

                val objednavkaText = "Souhrn objednávky: " +
                        "$car.text" +
                        (if (prevodovka) "; prevodovka" else "") +
                        (if (volant) "; volant" else "") +
                        (if (strecha) "; strecha" else "")

                binding.tvSummary.text = objednavkaText

            }

            //změna obrázku v závislosti na vybraném radiobuttonu

            binding.rbBmw.setOnClickListener {
                binding.ivCar.setImageResource(R.drawable.bmw)
            }

            binding.rbMercedes.setOnClickListener {
                binding.ivCar.setImageResource(R.drawable.mercedes)
            }

            binding.rbVolkswagen.setOnClickListener {
                binding.ivCar.setImageResource(R.drawable.volkswagen)
            }

            //Zobrazení snackbaru
            binding.btnSend.setOnClickListener {
                // Přidáme logiku pro zobrazení Snackbaru
                val snackbar = Snackbar.make(it, "Objednávka byla odeslána!", Snackbar.LENGTH_LONG)

                // Přidáme akci pro zavření Snackbaru
                snackbar.setAction("Zavřít") {
                    Toast.makeText(this, "Snackbar zavřen", Toast.LENGTH_SHORT).show()
                }

                // Změna barvy pozadí
                snackbar.setBackgroundTint(resources.getColor(R.color.black))

                // Zobrazíme Snackbar
                snackbar.show()
            }

        }
    }
}