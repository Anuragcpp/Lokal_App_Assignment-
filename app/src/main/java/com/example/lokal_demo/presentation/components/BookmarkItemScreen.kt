package com.example.lokal_demo.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lokal_demo.R
import com.example.lokal_demo.data.Bookmark
import kotlinx.coroutines.launch

@Composable
fun BookmarkItemScreen(
    navigateToDetailScreen : (Bookmark) -> Unit,
    deleteBookmark : ( Bookmark,String) -> Unit,
    bookmark: Bookmark
) {

    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }



    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.White)
            .clickable { navigateToDetailScreen(bookmark) },
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {

        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "${bookmark?.title ?: "Unknown"}",
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                ),
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Start
            )

            Text(
                text = "Location -  ${bookmark.Place ?: "Unknown places"}",
                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 16.sp),
                modifier = Modifier.padding(bottom = 4.dp)
            )

            Text(
                text = "Salary: ${bookmark.salary_min} - ${bookmark.salary_max} ",
                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 16.sp),
                modifier = Modifier.padding(bottom = 4.dp)
            )

            Text(
                text = "Phone: ${bookmark.whatsapp_no ?: "Unknown"}",
                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 16.sp),
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Button(
                    onClick = {
                        deleteBookmark(bookmark,"Bookmark Removed")
//                        scope.launch {
//                            snackbarHostState.showSnackbar("Bookmark Removed")
//                        }
                              },
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.red))
                ) {
                    Text(text = "Remove")
                }
            }
        }
    }
}