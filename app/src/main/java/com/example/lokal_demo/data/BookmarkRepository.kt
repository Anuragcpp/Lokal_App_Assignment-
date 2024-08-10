package com.example.lokal_demo.data

import kotlinx.coroutines.flow.Flow

class BookmarkRepository ( private val bookMarkDao: BookMarkDao) {
    suspend fun addBookmark (bookmark: Bookmark){
        bookMarkDao.addBookmark(bookmark)
    }

    fun getAllBookmarks () : Flow<List<Bookmark>> =bookMarkDao.getAllBookmarks()

    suspend fun deleteBookmark ( bookmark: Bookmark) {
        bookMarkDao.deleteBookmark(bookmark)
    }
}