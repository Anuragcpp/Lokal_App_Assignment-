package com.example.lokal_demo.viewModel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lokal_demo.data.Bookmark
import com.example.lokal_demo.data.BookmarkRepository
import com.example.lokal_demo.data.Graph
import com.example.lokal_demo.model.Job
import com.example.lokal_demo.services.jobServices
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class JobsScreenViewModel (
    private val bookmarkRepository: BookmarkRepository = Graph.bookmarkRepository
) : ViewModel() {
    private val _jobState = mutableStateOf(JobsState())
    val jobState : State<JobsState> = _jobState

    lateinit var getAllBookmark : Flow<List<Bookmark>>

    init {
        fetchJobs()
        viewModelScope.launch {
            getAllBookmark = bookmarkRepository.getAllBookmarks()
        }
    }

//    fun addBookmark( bookmark: Bookmark) {
//        viewModelScope.launch (Dispatchers.IO) {
//            bookmarkRepository.addBookmark(bookmark)
//        }
//    }

    fun deleteBookmark( bookmark: Bookmark) {
        viewModelScope.launch (Dispatchers.IO) {
            bookmarkRepository.deleteBookmark(bookmark)
        }
    }

    fun addData ( job: Job){
        viewModelScope.launch(Dispatchers.IO) {
//            val bookmark = Bookmark(
//                title = job.title,
//                salary_min = job.salary_min,
//                salary_max = job.salary_max,
//                whatsapp_no = job.whatsapp_no,
//                company_name = job.company_name,
//                Place = job.primary_details?.Place ?: "Unknown",
//                Salary = job.primary_details?.Salary ?: "Unknown",
//                Job_Type = job.primary_details?.Job_Type ?: "Unknown",
//                Qualification = job.primary_details?.Qualification ?: "Unknown",
//                Fees_Charged = job.primary_details?.Fees_Charged ?: "Unknown",
//                Experience = job.primary_details?.Experience ?: "Unknown"
//            )

            val bookmark = jobToBookmark(job)
            bookmarkRepository.addBookmark(bookmark)
        }
    }

    fun jobToBookmark ( job : Job) : Bookmark {
        return  Bookmark(
            title = job.title,
            salary_min = job.salary_min,
            salary_max = job.salary_max,
            whatsapp_no = job.whatsapp_no,
            company_name = job.company_name,
            Place = job.primary_details?.Place ?: "Unknown",
            Salary = job.primary_details?.Salary ?: "Unknown",
            Job_Type = job.primary_details?.Job_Type ?: "Unknown",
            Qualification = job.primary_details?.Qualification ?: "Unknown",
            Fees_Charged = job.primary_details?.Fees_Charged ?: "Unknown",
            Experience = job.primary_details?.Experience ?: "Unknown"
        )
    }



    private fun fetchJobs () {
        viewModelScope.launch {
            try {
                val response = jobServices.getJobs()
                _jobState.value = _jobState.value.copy(
                    loading = false,
                    list = response.results,
                    error = null
                )
                Log.i("Success", "data fetch successfully")
            }catch ( e : Exception){
                _jobState.value = _jobState.value.copy(
                    loading = false,
                    error =  "Error fetching jobs ${e.message}"
                )
                Log.i("Failed", "data fetching Unsuccessful")
            }
        }
    }



    data class JobsState (
        var loading : Boolean = true,
        var list : List<Job> = emptyList(),
        var error : String? = null
    )
}