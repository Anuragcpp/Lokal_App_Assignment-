package com.example.lokal_demo.presentation

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lokal_demo.model.Job
import com.example.lokal_demo.presentation.components.JobCategoryScreen
import com.example.lokal_demo.presentation.components.JobItemScreen
import com.example.lokal_demo.viewModel.JobsScreenViewModel

@Composable
fun JobsScreen(
    viewState : JobsScreenViewModel.JobsState,
    navigateToDetailScreen : (Job) -> Unit,
    addData : (Job,String) -> Unit
) {

    val jobViewModel : JobsScreenViewModel = viewModel()


    Box(modifier = Modifier.fillMaxSize()){
        when {
            viewState.loading -> {
                Column (modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    // for the loading progress bar
//                    CircularProgressIndicator(modifier.align(Alignment.Center))
                    CircularProgressIndicator()
                    Text(
                        text = "Loading....",
//                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }

            viewState.error != null -> {
                Text(text = "Error Occurred ${viewState.error.toString()}")
            }

            else -> {
                JobCategoryScreen(jobs = viewState.list, navigateToDetailScreen, addData)
            }
        }
    }


}


