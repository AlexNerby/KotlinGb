package com.example.kotlingb.ui.main

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlingb.R

class MainActivity : AppCompatActivity() {

    companion object {
        const val LOG = true
    }

    private val TAG = "KotlinGbMainActivity"

    private var isStart = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.v(TAG, "onCreate")

        val buttonLessonOne = findViewById<Button>(R.id.button)
        buttonLessonOne.setOnClickListener {
            if (LOG) {
                Log.d(TAG, "buttonLessonOne.setOnClickListener")
            }

            if (isStart) {
                buttonLessonOne.text = getString(R.string.button_start_lesson_1)
            } else {
                buttonLessonOne.text = getString(R.string.button_stop_lesson_1)
            }
            isStart = !isStart
        }
    }
}