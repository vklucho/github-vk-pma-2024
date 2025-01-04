package com.example.myapp016avanocniappka

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RecipeDetailActivity : AppCompatActivity() {

    private lateinit var recipeImage: ImageView
    private lateinit var recipeName: TextView
    private lateinit var recipeIngredients: TextView
    private lateinit var recipeInstructions: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_detail)

        recipeImage = findViewById(R.id.recipeImage)
        recipeName = findViewById(R.id.recipeName)
        recipeIngredients = findViewById(R.id.recipeIngredients)
        recipeInstructions = findViewById(R.id.recipeInstructions)

        val recipe = intent.getSerializableExtra("recipe") as Recipe

        recipeImage.setImageResource(recipe.imageResId)
        recipeName.text = recipe.name
        recipeIngredients.text = recipe.ingredients.joinToString(", ")
        recipeInstructions.text = recipe.instructions
    }
}
