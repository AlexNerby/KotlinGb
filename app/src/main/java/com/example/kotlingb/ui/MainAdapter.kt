package com.example.kotlingb.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlingb.R
import com.example.kotlingb.model.Note

class MainAdapter: RecyclerView.Adapter<MainAdapter.NoteViewHolder>() {
    private val TAG = "KotlinGbMainAdapter"

    init {
        Log.d(TAG, "init adapter")
    }

    var  notes: List<Note> = listOf()
    set(value) {
        Log.d(TAG, "setter adapter")
        field = value
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        Log.d(TAG, "onCreateViewHolder")
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.main_item, parent, false)

        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        Log.d(TAG, "position: $position")

        holder.bind(notes[position])
    }

    override fun getItemCount(): Int = notes.size

    class NoteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val title = itemView.findViewById<TextView>(R.id.title_main_item)
        private val text = itemView.findViewById<TextView>(R.id.text_main_item)
        private val cardView = itemView.findViewById<CardView>(R.id.card_view_note)

        fun bind(note: Note) {

            title.text = note.title
            text.text = note.note
            cardView.setCardBackgroundColor(note.color)
        }
    }
}