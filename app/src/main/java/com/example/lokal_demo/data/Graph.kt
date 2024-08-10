package com.example.lokal_demo.data

import android.content.Context
import androidx.room.Room

object Graph {
    lateinit var database: BookmarkDatabase

    val bookmarkRepository by lazy {
        BookmarkRepository(bookMarkDao = database.bookmarkDao())
    }

    fun provide (context: Context){
        database = Room.databaseBuilder(context,BookmarkDatabase::class.java,"bookmarklist.db").build()
    }
}