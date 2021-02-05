package com.example.kotlingb.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlingb.R
import com.example.kotlingb.databinding.MainItemBinding
import com.example.kotlingb.model.Color
import com.example.kotlingb.model.Note

interface OnItemClickListener {
    fun onItemClick(note: Note)
}

class MainAdapter(private val onItemClickListener: OnItemClickListener): RecyclerView.Adapter<MainAdapter.NoteViewHolder>() {
    private val TAG = "KotlinGbMainAdapter"

    var notes: List<Note> = listOf()
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

    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val ui: MainItemBinding = MainItemBinding.bind(itemView)

        fun bind(note: Note) {
            ui.titleMainItem.text = note.title
            ui.textMainItem.text = note.note

            val color = when (note?.color) {
                Color.WHITE -> R.color.color_white
                Color.VIOLET -> R.color.color_violet
                Color.YELLOW -> R.color.color_yello
                Color.RED -> R.color.color_red
                Color.PINK -> R.color.color_pink
                Color.GREEN -> R.color.color_green
                Color.BLUE -> R.color.color_blue

            }
            ui.cardViewNote.setCardBackgroundColor(itemView.context.resources.getColor(color))
//            ui.cardViewNote.setBackgroundResource(color)  //не работает cornerRadius
            itemView.setOnClickListener { onItemClickListener.onItemClick(note) }
        }
    }
}