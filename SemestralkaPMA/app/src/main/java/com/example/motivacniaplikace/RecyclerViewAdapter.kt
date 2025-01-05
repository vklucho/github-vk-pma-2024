package com.example.motivacniaplikace

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Adapter pro RecyclerView zobrazující oblíbené citáty
class RecyclerViewAdapter(
    private val favoriteQuotes: List<Quote>,
    private val onFavoriteToggle: (Quote) -> Unit
) : RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewViewHolder>() {

    // ViewHolder třída pro RecyclerView položky
    class RecyclerViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvQuote: TextView = itemView.findViewById(R.id.tvQuote)
        val btnRemoveFavorite: Button = itemView.findViewById(R.id.btnRemoveFavorite)
    }

    // Metoda pro vytvoření nového ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_favorite_quote, parent, false)
        return RecyclerViewViewHolder(itemView)
    }

    // Metoda pro vazbu dat k ViewHolder
    override fun onBindViewHolder(holder: RecyclerViewViewHolder, position: Int) {
        val quote = favoriteQuotes[position]
        holder.tvQuote.text = quote.text
        holder.btnRemoveFavorite.setOnClickListener {
            onFavoriteToggle(quote)
        }
    }

    // Metoda pro získání počtu položek v seznamu
    override fun getItemCount() = favoriteQuotes.size
}
