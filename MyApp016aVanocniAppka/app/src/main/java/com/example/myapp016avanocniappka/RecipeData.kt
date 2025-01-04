package com.example.myapp016avanocniappka

object RecipeData {

    fun getSweetRecipes(): List<Recipe> {
        return listOf(
            Recipe(
                "Vánoční cukroví",
                R.drawable.cukrovi,
                listOf("150g cukru", "200g másla", "300g mouky", "1 vejce", "100g ořechů"),
                "Postup: 1. Smíchejte cukr, máslo a vejce. 2. Přidejte mouku a ořechy, vypracujte těsto. 3. Těsto vyválejte na tenkou placku, vykrajujte tvary a pečte 10 minut při 180°C."
            ),
            Recipe(
                "Vánoční štola",
                R.drawable.stola,
                listOf("500g mouky", "200g rozinek", "100g mandlí", "100g másla", "1 vejce", "200ml mléka"),
                "Postup: 1. Smíchejte mouku, rozinky, mandle a prášek do pečiva. 2. Přidejte máslo, vejce a mléko, vypracujte těsto. 3. Nechte kynout 30 minut. 4. Vytvarujte štolu a pečte 1 hodinu při 170°C."
            ),
            Recipe(
                "Vánoční perníčky",
                R.drawable.pernicky,
                listOf("300g medu", "200g cukru", "1 vejce", "1 lžička skořice", "400g mouky"),
                "Postup: 1. Smíchejte med, cukr a vejce. 2. Přidejte skořici a mouku, vypracujte těsto. 3. Nechte těsto odpočinout 1 hodinu. 4. Vyválejte na placku, vykrajujte tvary a pečte 8 minut při 180°C."
            ),
            Recipe(
                "Vánoční truffles",
                R.drawable.truffles,
                listOf("200g čokolády", "100ml smetany", "1 lžíce rumu", "kakaový prášek na obalení"),
                "Postup: 1. Rozehřejte čokoládu se smetanou na mírném ohni. 2. Přidejte rum a dobře promíchejte. 3. Nechte zchladnout, tvořte kuličky a obalte v kakau."
            ),
            Recipe(
                "Cukroví s ořechy",
                R.drawable.cukrovi_s_orechy,
                listOf("100g cukru", "100g másla", "200g mouky", "100g vlašských ořechů"),
                "Postup: 1. Smíchejte cukr, máslo a mouku. 2. Přidejte ořechy a vypracujte těsto. 3. Tvořte malé kuličky, pečte 15 minut při 175°C."
            ),
            Recipe(
                "Marcipánové koule",
                R.drawable.marcipanove_koule,
                listOf("200g marcipánu", "50g cukru", "100g čokolády na potření"),
                "Postup: 1. Marcipán rozdrobte a smíchejte s cukrem. 2. Tvořte malé kuličky a nechte je zatuhnout. 3. Rozehřejte čokoládu a obalte kuličky."
            ),
            Recipe(
                "Vánoční koláče",
                R.drawable.kolace,
                listOf("500g mouky", "100g cukru", "150g másla", "1 vejce", "100g povidel"),
                "Postup: 1. Smíchejte mouku, cukr, máslo a vejce, vypracujte těsto. 2. Rozválejte, nakrájejte na čtverce a na střed dejte povidla. 3. Pečte 20 minut při 180°C."
            ),
            Recipe(
                "Vánoční panna cotta",
                R.drawable.panna_cotta,
                listOf("500ml smetany", "100g cukru", "1 vanilkový lusk", "10g želatiny"),
                "Postup: 1. Smetanu zahřejte s cukrem a vanilkovým luskem. 2. Rozpusťte želatinu v troše vody a přidejte ji do smetany. 3. Nalijte do formiček a nechte ztuhnout v lednici."
            ),
            Recipe(
                "Zázvorové sušenky",
                R.drawable.zazvorove_susenky,
                listOf("150g másla", "100g cukru", "200g mouky", "1 lžička zázvoru"),
                "Postup: 1. Smíchejte máslo, cukr, mouku a zázvor. 2. Vypracujte těsto a nechte ho odpočinout 30 minut. 3. Vyválejte, vykrajujte tvary a pečte 12 minut při 180°C."
            )
        )
    }

    fun getSaltyRecipes(): List<Recipe> {
        return listOf(
            Recipe(
                "Sýrové tyčinky",
                R.drawable.syrove_tycky,
                listOf("250g sýra", "100g másla", "300g mouky", "1 vejce"),
                "Postup: 1. Smíchejte sýry, máslo a vejce. 2. Přidejte mouku, vypracujte těsto. 3. Tvořte tyčinky a pečte 20 minut při 180°C."
            ),
            Recipe(
                "Vánoční slané koláče",
                R.drawable.slane_kolace,
                listOf("500g mouky", "200g šunky", "100g sýra", "1 vejce"),
                "Postup: 1. Smíchejte mouku, šunku, sýr a vejce. 2. Vypracujte těsto a tvarujte malé koláčky. 3. Pečte 15 minut při 180°C."
            ),
            Recipe(
                "Vánoční chlebíčky",
                R.drawable.chlebicky,
                listOf("500g pšeničné mouky", "100g slaniny", "50g cibule", "1 vejce", "150ml mléka"),
                "Postup: 1. Smíchejte mouku, slaninu, cibuli, vejce a mléko. 2. Tvořte malé chlebíčky a pečte 25 minut při 180°C."
            ),
            Recipe(
                "Vánoční quiche",
                R.drawable.quiche,
                listOf("1 těsto na quiche", "100g šunky", "100g sýra", "2 vejce", "200ml smetany"),
                "Postup: 1. Roztáhněte těsto do formy. 2. Na něj položte šunku a sýr. 3. Smíchejte vejce se smetanou, nalijte na šunku a pečte 30 minut při 180°C."
            ),
            Recipe(
                "Bramborové placky",
                R.drawable.bramborove_placky,
                listOf("500g brambor", "100g mouky", "1 vejce", "sůl", "pepř"),
                "Postup: 1. Nastrouhejte brambory a smíchejte je s moukou, vejcem, solí a pepřem. 2. Vytvořte placky a smažte je na pánvi do zlatova."
            )
        )
    }

    fun getDrinkRecipes(): List<Recipe> {
        return listOf(
            Recipe(
                "Vánoční punč",
                R.drawable.vanocni_punc,
                listOf("500ml šťávy", "100ml rumu", "skořice", "hřebíček", "cukr"),
                "Postup: 1. Smíchejte šťávu, rum a koření. 2. Zahřejte na mírném ohni a nechte vařit 10 minut. 3. Podávejte teplé s plátky pomeranče."
            ),
            Recipe(
                "Vánoční grog",
                R.drawable.grog,
                listOf("200ml vody", "50ml rumu", "1 lžíce cukru", "pomerančová kůra"),
                "Postup: 1. Zahřejte vodu s cukrem a pomerančovou kůrou. 2. Přidejte rum a dobře promíchejte. 3. Podávejte teplé."
            ),
            Recipe(
                "Vánoční horká čokoláda",
                R.drawable.horka_cokolada,
                listOf("300ml mléka", "100g čokolády", "1 lžíce cukru", "šlehačka"),
                "Postup: 1. Zahřejte mléko a rozpusťte v něm čokoládu. 2. Přidejte cukr a dobře promíchejte. 3. Podávejte s šlehačkou."
            )
        )
    }
}