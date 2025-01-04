package com.example.myapp008bfragmentsexample1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val gameFragment = GameFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_list, gameFragment)
                .commit()
        }
    }

    // Voláno při výběru položky
    fun onBookSelected(title: String, imageResId: Int, description: String) {
        val detailFragment = DetailFragment()
        val bundle = Bundle().apply {
            putString("games", title)
            putInt("imageResId", imageResId)
            putString("description", description)
        }
        detailFragment.arguments = bundle

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_detail, detailFragment)
            .commit()
    }
}
