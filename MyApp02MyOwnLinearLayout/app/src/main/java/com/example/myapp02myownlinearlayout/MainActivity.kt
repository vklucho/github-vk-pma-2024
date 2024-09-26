package com.example.myapp02myownlinearlayout

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        /*
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        } */

        val etName = findViewById<EditText>(R.id.etName)
        val etSurname = findViewById<EditText>(R.id.etSurname)
        val tvInformation = findViewById<TextView>(R.id.tvInformation)
        val btnClick = findViewById<Button>(R.id.btnClick)

        var pocet = 0

        btnClick.setOnClickListener{
            val name = etName.text.toString()
            val surname = etSurname.text.toString()
            pocet++

            val formattedText = "Jmenuji se $name $surname . A kliknul jsem již $pocet x"
            tvInformation.text = formattedText

        }

    }
}