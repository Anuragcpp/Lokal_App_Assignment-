package com.example.lokal_demo.presentation.components

import androidx.compose.ui.graphics.Color

    fun hexToColor(hex: String): Color {
        // Remove the hash symbol if present
        val cleanedHex = hex.removePrefix("#")
        // Parse the color components
        val colorLong = cleanedHex.toLong(16)
        return when (cleanedHex.length) {
            6 -> Color(colorLong or 0x00000000FF000000)
            8 -> Color(colorLong)
            else -> throw IllegalArgumentException("Invalid hex color code: $hex")
        }
    }
