package com.example.lokal_demo.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class Job(
    val id : String,
    val title : String,
    val primary_details : @RawValue PrimaryDetails?,
    val salary_min : Float,
    val salary_max : Float,
    val whatsapp_no : String,
    val company_name : String,
) : Parcelable

data class JobsResponse (
    val results : List<Job>
)


@Parcelize
data class PrimaryDetails (
    val Place: String,
    val Salary: String,
    val Job_Type: String,
    val Experience: String,
    val Fees_Charged: String,
    val Qualification: String
) : Parcelable
