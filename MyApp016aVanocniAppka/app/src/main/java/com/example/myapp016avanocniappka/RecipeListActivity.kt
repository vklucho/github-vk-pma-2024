package com.example.myapp016avanocniappka

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecipeListActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var recipeAdapter: RecipeAdapter
    private lateinit var recipeList: List<Recipe>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_list)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val category = intent.getStringExtra("category") ?: ""

        recipeList = when (category) {
            "Sladké" -> RecipeData.getSweetRecipes()
            "Slané" -> RecipeData.getSaltyRecipes()
            "Nápoje" -> RecipeData.getDrinkRecipes()
            else -> emptyList()
        }

        recipeAdapter = RecipeAdapter(recipeList) { recipe ->
            val intent = Intent(this, RecipeDetailActivity::class.java)
            intent.putExtra("recipe", recipe)
            startActivity(intent)
        }

        recyclerView.adapter = recipeAdapter
    }
}

