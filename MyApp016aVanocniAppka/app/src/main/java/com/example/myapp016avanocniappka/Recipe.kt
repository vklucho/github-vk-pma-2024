package com.example.myapp016avanocniappka

import java.io.Serializable

data class Recipe(
    val name: String,
    val imageResId: Int,
    val ingredients: List<String>,
    val instructions: String
) : Serializable
