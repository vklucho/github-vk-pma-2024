package com.example.myapp016avanocniappka

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var categoryAdapter: CategoryAdapter
    private val categories = listOf("Sladké", "Slané", "Nápoje")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        categoryAdapter = CategoryAdapter(categories) { category ->
            val intent = Intent(this, RecipeListActivity::class.java)
            intent.putExtra("category", category)
            startActivity(intent)
        }

        recyclerView.adapter = categoryAdapter
    }
}

