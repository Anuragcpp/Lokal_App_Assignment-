package com.example.lokal_demo.viewModel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lokal_demo.model.Job
import com.example.lokal_demo.services.jobServices
import kotlinx.coroutines.launch

class JobsScreenViewModel : ViewModel() {
    private val _jobState = mutableStateOf(JobsState())
    val jobState : State<JobsState> = _jobState

    init {
        fetchJobs()
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