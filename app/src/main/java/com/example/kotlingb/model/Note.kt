package com.example.kotlingb.model

import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Note(
        val id: String,
        val title: String,
        val note: String,
        val color: Int,
        val lastChanged: Date = Date()
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Note

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}