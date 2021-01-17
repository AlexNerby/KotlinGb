package com.example.kotlingb

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    companion object {
        const val LOG = true
        const val TAG = "KotlinGbMainActivity"
    }

    private var isStart = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate")

        val buttonLessonOne = findViewById<Button>(R.id.button)
        buttonLessonOne.setOnClickListener {
            if (LOG) {
                Log.v(TAG, "buttonLessonOne.setOnClickListener")
            }

            if (isStart) {
                buttonLessonOne.text = getString(R.string.button_start_lesson_1)
                isStart = false
            } else {
                buttonLessonOne.text = getString(R.string.button_stop_lesson_1)
                isStart = true
            }
        }
    }
}