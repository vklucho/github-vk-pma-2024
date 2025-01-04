package com.example.myapp008bfragmentsexample1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class DetailFragment : Fragment() {

    private lateinit var textViewGame: TextView
    private lateinit var imageView: ImageView
    private lateinit var textViewDescription: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        textViewGame = view.findViewById(R.id.textViewGame)
        imageView = view.findViewById(R.id.ivPhoto)
        textViewDescription = view.findViewById(R.id.textViewDescription)

        arguments?.let {
            textViewGame.text = it.getString("game")
            imageView.setImageResource(it.getInt("imageResId"))
            textViewDescription.text = it.getString("description")
        }
        return view
    }
}

