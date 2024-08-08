package com.example.lokal_demo.presentation

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.lokal_demo.model.Jobs
import com.example.lokal_demo.presentation.components.JobItemScreen

@Composable
fun JobsScreen(modifier: Modifier = Modifier) {

    val jobs = remember { getJobsList() }

    LazyColumn {
        items(jobs){
            JobItemScreen( job = it)
        }
    }
}


fun getJobsList () : List<Jobs> {
    return listOf(
        Jobs(
            id = "1",
            title = "Software engineer",
            location = "Hydrabad",
            minSalary = 20000f,
            maxSalary = 30000f,
            phoneNumber = "293877289"
        ),
        Jobs(
            id = "1",
            title = "Software engineer",
            location = "Hydrabad",
            minSalary = 20000f,
            maxSalary = 30000f,
            phoneNumber = "293877289"
        ),
        Jobs(
            id = "1",
            title = "Software engineer",
            location = "Hydrabad",
            minSalary = 20000f,
            maxSalary = 30000f,
            phoneNumber = "293877289"
        ),
        Jobs(
            id = "1",
            title = "Software engineer",
            location = "Hydrabad",
            minSalary = 20000f,
            maxSalary = 30000f,
            phoneNumber = "293877289"
        ),
        Jobs(
            id = "1",
            title = "Software engineer",
            location = "Hydrabad",
            minSalary = 20000f,
            maxSalary = 30000f,
            phoneNumber = "293877289"
        ),
        Jobs(
            id = "1",
            title = "Software engineer",
            location = "Hydrabad",
            minSalary = 20000f,
            maxSalary = 30000f,
            phoneNumber = "293877289"
        ),
        Jobs(
            id = "1",
            title = "Software engineer",
            location = "Hydrabad",
            minSalary = 20000f,
            maxSalary = 30000f,
            phoneNumber = "293877289"
        )
    )
}