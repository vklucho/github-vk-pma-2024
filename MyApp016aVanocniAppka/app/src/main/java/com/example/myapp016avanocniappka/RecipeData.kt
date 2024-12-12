package com.example.myapp016avanocniappka

object RecipeData {

    fun getSweetRecipes(): List<Recipe> {
        return listOf(
            Recipe(
                "Vánoční cukroví",
                R.drawable.cukrovi,
                listOf("150g cukru", "200g másla", "300g mouky"),
                "Postup: Vše smíchejte, vytvarujte malé koule a pečte 15 minut."
            ),
            Recipe(
                "Vánoční štola",
                R.drawable.stola,
                listOf("500g mouky", "200g rozinek", "100g mandlí"),
                "Postup: Vše smíchejte, nechte kynout a pečte 1 hodinu."
            )
        )
    }

    fun getSaltyRecipes(): List<Recipe> {
        return listOf(
            Recipe(
                "Sýrové tyčinky",
                R.drawable.syrove_tycky,
                listOf("250g sýra", "100g másla", "300g mouky"),
                "Postup: Vše smíchejte a vytvarujte tyčinky, pečte 20 minut."
            )
        )
    }

    fun getDrinkRecipes(): List<Recipe> {
        return listOf(
            Recipe(
                "Vánoční punč",
                R.drawable.vanocni_punc,
                listOf("500ml šťávy", "100ml rumu", "skořice"),
                "Postup: Vše smíchejte a vařte na mírném ohni 10 minut."
            )
        )
    }
}
