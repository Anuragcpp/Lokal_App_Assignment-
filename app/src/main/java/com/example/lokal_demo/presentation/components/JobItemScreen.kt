package com.example.lokal_demo.presentation.components

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.lokal_demo.model.Job


@Composable
fun JobItemScreen(
    job : Job ,
    navigateToDetailScreen : (Job) -> Unit
) {



    Box(modifier = Modifier
        .fillMaxSize()
        .clickable {
            navigateToDetailScreen(job)
        }
        .padding(start = 5.dp, top = 5.dp, end = 5.dp, bottom = 5.dp)
    ){


            Column (modifier = Modifier.padding(5.dp)
                .border(1.dp, color = Color.Cyan, shape = RoundedCornerShape(15.dp))
                .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){

                Text(text = " id - ${job.id}")
                Text(text = " title - ${job.title} ")
                Text(text = " location -  ${job.primary_details?.Place ?: "Unknown places"}" )
                Text(text = " ${job.salary_min} - ${job.salary_max} ")
                Text(text = " phone number - ${job.whatsapp_no}")

            }


    }

}

fun displayToast(context: Context, job: Job){
    Toast.makeText(context,"${job.id} ${job.title}", Toast.LENGTH_LONG).show()
}

