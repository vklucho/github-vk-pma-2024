package com.example.myapp004objednavka

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.RadioButton
import android.widget.RadioGroup
import com.example.myapp004objednavka.databinding.ActivityMainBinding




class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        //binding settings
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Objednávka vozidla"

        binding.btnSend.setOnClickListener{
            //načtení ID vybraného radiobuttonu z radiogroup
            val carRbId = binding.rgCar.checkedRadioButtonId
            val car = findViewById<RadioButton>(carRbId)

            val prevodovka = binding.cbPrevodovka.isChecked
            val volant = binding.cbVolant.isChecked
            val strecha = binding.cbStrecha.isChecked

            val objednavkaText = "Souhrn objednávky: " +
                    "$car.text" +
                    (if(prevodovka)"; prevodovka" else "") +
                    (if(volant)"; volant" else "") +
                    (if(strecha)"; strecha" else "")

            binding.tvSummary.text = objednavkaText

        }

        //změna obrázku v závislosti na vybraném radiobuttonu

        binding.rbBmw.setOnClickListener{
            binding.ivCar.setImageResource(R.drawable.bmw)
        }

        binding.rbMercedes.setOnClickListener{
            binding.ivCar.setImageResource(R.drawable.mercedes)
        }

        binding.rbVolkswagen.setOnClickListener{
            binding.ivCar.setImageResource(R.drawable.volkswagen)
        }


    }
}