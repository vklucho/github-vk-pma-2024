package com.example.myapp012aimagetoapp

import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.net.Uri
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.myapp012aimagetoapp.databinding.ActivityMainBinding

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

        binding.btnTakeImage.setOnClickListener {
            getContent.launch("image/*")
        }

        binding.btnBlackAndWhite.setOnClickListener {
            applyBlackAndWhiteFilter()
        }
    }

    private fun applyBlackAndWhiteFilter() {
        val colorMatrix = ColorMatrix()
        colorMatrix.setSaturation(0f)
        val filter = ColorMatrixColorFilter(colorMatrix)
        binding.ivImage.colorFilter = filter
    }
}
