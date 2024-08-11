package com.example.lokal_demo.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lokal_demo.R
import com.example.lokal_demo.data.Bookmark
import com.example.lokal_demo.presentation.components.hexToColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookmarkJobDetailScreen(
    bookmark: Bookmark,
    backBtn : () -> Unit
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Job Details",
                        color = colorResource(id = R.color.white),
                        modifier = Modifier
                            .padding(start = 5.dp)
                            .heightIn(max = 24.dp)
                    )
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = hexToColor("#1d3557")
                ),
                navigationIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_arrow_back_ios_24),
                        contentDescription = "back icon",
                        modifier = Modifier.clickable { backBtn() }.padding(start = 5.dp, end = 5.dp),
                        tint = Color.White
                    )
                },
                modifier = Modifier.heightIn(max = 60.dp)
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
                .fillMaxSize()
                .background(Color.White)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = bookmark.title,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = hexToColor("#2C3E50"),
                modifier = Modifier.padding(bottom = 16.dp)
            )

            DetailRow(label = "Company", value = bookmark.company_name)
            DetailRow(label = "Location", value = bookmark.Place)
            DetailRow(label = "Salary", value = bookmark.Salary)
            DetailRow(label = "Job Type", value = bookmark.Job_Type)
            DetailRow(label = "Experience", value = bookmark.Experience)
            DetailRow(label = "Qualification", value = bookmark.Qualification)
            DetailRow(label = "Fees Charged", value = bookmark.Fees_Charged)
            DetailRow(label = "WhatsApp", value = bookmark.whatsapp_no)
            DetailRow(label = "Salary Range", value = "${bookmark.salary_min} - ${bookmark.salary_max}")

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    // Action for applying to the job
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = hexToColor("#76c893"))
            ) {
                Text(text = "Apply Now", color = Color.White)
            }
        }
    }

}