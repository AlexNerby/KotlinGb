package com.example.kotlingb.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlingb.R
import com.example.kotlingb.databinding.ActivityMainBinding
import com.example.kotlingb.model.Note
import com.example.kotlingb.ui.MainViewState
import com.example.kotlingb.ui.note.NoteActivity
import com.example.kotlingb.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    companion object {
        const val LOG = true
    }

    private val TAG = "KotlinGbMainActivity"

    lateinit var ui: ActivityMainBinding
    lateinit var viewModel: MainViewModel
    lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui = ActivityMainBinding.inflate(layoutInflater)
        setContentView(ui.root)
        Log.v(TAG, "onCreate")

    fun test(note: Note) {}


        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        setSupportActionBar(ui.toolbar)

        adapter = MainAdapter(object : OnItemClickListener {
            override fun onItemClick(note: Note) {
                openNoteScreen(note)
            }

        })
        ui.mainRecycler.adapter = adapter

        viewModel.viewState().observe(this,{
            it?.let { adapter.notes = it.notes }
        })

        ui.fab.setOnClickListener { openNoteScreen() }
    }

    private fun openNoteScreen(note: Note? = null) {
        val intent = NoteActivity.getStartIntent(this, note)
        startActivity(intent)
    }
}