package com.example.lokal_demo.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.lokal_demo.model.Job

@Composable
fun JobDetailScreen(
    job : Job
) {

    Column( modifier = Modifier
        .fillMaxSize()
        .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        
        Text(text = " id - ${job.id}")
        Text(text = " Title -  ${job.title}")
        Text(text = " Location - ${job.primary_details?.Place ?: "Unknown"}")
        Text(text = "Salary - ${job.salary_min} - ${job.salary_max}")
        Text(text = "Phone number - ${job.whatsapp_no}")

    }

}