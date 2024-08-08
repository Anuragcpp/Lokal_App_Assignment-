package com.example.lokal_demo.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lokal_demo.model.Jobs


@Preview(showBackground = true)
@Composable
fun JobItemScreen(
    job : Jobs = Jobs(
        id = "1",
        title = "Software engineer",
        location = "Hydrabad",
        minSalary = 20000f,
        maxSalary = 30000f,
        phoneNumber = "293877289"
    )
) {



}

