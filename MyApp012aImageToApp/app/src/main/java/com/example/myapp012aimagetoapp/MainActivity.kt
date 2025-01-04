package com.example.myapp012aimagetoapp

import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapp012aimagetoapp.databinding.ActivityMainBinding
import android.content.Intent


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var uri: Uri? = null  // Globální proměnná pro uložení URI obrázku


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val getContent = registerForActivityResult(ActivityResultContracts.GetContent()) { selectedUri: Uri? ->
            uri = selectedUri  // Uložení URI obrázku do globální proměnné
            binding.ivImage.setImageURI(uri)
        }

        binding.btnTakeImage.setOnClickListener(){
            getContent.launch("image/*")
        }

        binding.ivImage.setOnClickListener {
            uri?.let {
                val intent = Intent(this, FullScreenImageActivity::class.java)
                intent.putExtra("image_uri", it)  // Předání URI obrázku nové aktivitě
                startActivity(intent)
            }
        }
    }
}