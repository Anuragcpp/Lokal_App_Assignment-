package com.example.lokal_demo.data

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "bookmark-table")
data class Bookmark(

    @PrimaryKey(autoGenerate = true)
    val id : Long = 0L,

    @ColumnInfo(name = "bookmark-title")
    val title : String,

    @ColumnInfo(name = "bookmark-salary_min")
    val salary_min : Float,

    @ColumnInfo(name = "bookmark-salary_max")
    val salary_max : Float,

    @ColumnInfo(name = "bookmark-whatsapp_no")
    val whatsapp_no : String,

    @ColumnInfo(name = "bookmark-company_name")
    val company_name : String,

    @ColumnInfo(name = "bookmark-place")
    val Place: String,

    @ColumnInfo(name = "bookmark-salary")
    val Salary: String,

    @ColumnInfo(name = "bookmark-Job_type")
    val Job_Type: String,

    @ColumnInfo(name = "bookmark-experience")
    val Experience: String,

    @ColumnInfo(name = "bookmark-fees_charged")
    val Fees_Charged: String,

    @ColumnInfo(name = "bookmark-qualification")
    val Qualification: String
) : Parcelable
