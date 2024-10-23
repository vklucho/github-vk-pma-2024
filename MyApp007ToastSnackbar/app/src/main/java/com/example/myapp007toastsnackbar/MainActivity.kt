package com.example.myapp007toastsnackbar

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapp007toastsnackbar.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnShowToast.setOnClickListener {
            showCustomToast("Nazdar - mám hlad")
        }
    }


    private fun showCustomToast(message: String) {

        val inflater = LayoutInflater.from(this)
        val layout = inflater.inflate(R.layout.custom_toast, null)


        val toastMessage: TextView = layout.findViewById(R.id.toast_message)
        val toastIcon: ImageView = layout.findViewById(R.id.toast_icon)
        toastMessage.text = message
        toastIcon.setImageResource(R.drawable.toast)

        val toast = Toast(this)
        toast.duration = Toast.LENGTH_LONG
        toast.view = layout
        toast.show()

        binding.btnShowSnackbar.setOnClickListener {

            val snackbar = Snackbar.make(it, "Toto je Snackbar!", Snackbar.LENGTH_LONG)


            snackbar.setDuration(7000)
            snackbar.setBackgroundTint((Color.parseColor("#222222")))

            snackbar.setAction("Zavřít") {
                Toast.makeText(this, "Zavírám Snackbar", Toast.LENGTH_LONG).show()
            }

            snackbar.show()

        }
    }
}
