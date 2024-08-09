package com.example.lokal_demo.presentation.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.lokal_demo.model.Job

@Composable
fun JobCategoryScreen(
    jobs : List<Job>,
    navigateToDetailScreen: (Job) -> Unit
) {

    LazyColumn (modifier = Modifier.fillMaxSize()) {
        items(jobs){
            JobItemScreen( job = it,navigateToDetailScreen )
        }
    }

}