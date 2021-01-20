package com.example.kotlingb.model

object Repository {

    private val notes: List<Note>

    init {
        notes = listOf(
                Note("One", "Message body...",
                        0xfff06292.toInt()),
                Note("Two", "Message body...",
                        0xfff06292.toInt()),
                Note("Three", "Message body...",
                        0xfff06292.toInt()),
                Note("Fore", "Message body...",
                        0xfff06292.toInt()),
                Note("Five", "Message body...",
                        0xfff06292.toInt()),
        )
    }

    fun getNotes(): List<Note> = notes
}