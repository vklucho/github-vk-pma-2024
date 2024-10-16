package com.example.myapp007toastsnackbar

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapp007toastsnackbar.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnnShowToast.setOnClickListener{
            val toast = Toast.makeText(this, "nazdar - mám hlad", Toast.LENGTH_LONG)

            toast.show()
        }

        binding.btnShowSnackbar.setOnClickListener{
            Snackbar.make(binding.root, "já jsem snackbar", Snackbar.LENGTH_LONG)
                .setDuration(7000)
                .setBackgroundTint(Color.parseColor("#ff3578"))
                .setAction("zavřít"){
                    Toast.makeText(this, "zavírám", Toast.LENGTH_SHORT).show()
                }
                .show()
        }
    }
}