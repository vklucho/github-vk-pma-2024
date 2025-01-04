package com.example.myapp008bfragmentsexample1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView

class GameFragment : Fragment() {

    private lateinit var listView: ListView
    private val game = listOf(
        listOf("GTA 5", R.drawable.gta, "Akční hra third person."),
        listOf("Forza", R.drawable.forza, "Závodní auta."),
        listOf("Formule", R.drawable.formule, "Závodní formule.")
    )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_item_list, container, false)
        listView = view.findViewById(R.id.listViewGame)

        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_1,
            game.map { it.first() }
        )
        listView.adapter = adapter

        // Při kliknutí na položku zavoláme metodu aktivity
        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedGame = game[position]
            (activity as? MainActivity)?.onBookSelected(
                selectedGame[0] as String,  // Název
                selectedGame[1] as Int,     // ID obrázku
                selectedGame[2] as String   // Popis
            )
        }
        return view
    }
}