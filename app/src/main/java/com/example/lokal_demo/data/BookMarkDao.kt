package com.example.lokal_demo.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
abstract class BookMarkDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun addBookmark ( entryBookmark: Bookmark)

    @Query("select * from `bookmark-table`")
    abstract fun getAllBookmarks () : Flow<List<Bookmark>>

    @Delete
    abstract suspend fun deleteBookmark(entryBookmark: Bookmark)
}