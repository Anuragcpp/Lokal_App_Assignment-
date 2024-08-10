package com.example.lokal_demo.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lokal_demo.data.Bookmark
import com.example.lokal_demo.presentation.components.BookmarkItemScreen
import com.example.lokal_demo.viewModel.JobsScreenViewModel

@Composable
fun BookmerksScreen(
    viewModel: JobsScreenViewModel,
    navigateToDetailScreen : (Bookmark) -> Unit,
    deleteBookmark : (Bookmark,String) -> Unit,
) {

    val allBookmark = viewModel.getAllBookmark.collectAsState(initial = listOf())

    Box(modifier = Modifier
        .fillMaxSize()){

        if (allBookmark.value.isEmpty()){
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Text(
                    text = "No Bookmarks Available",
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                )

            }
        }


        LazyColumn (modifier = Modifier.fillMaxSize()) {
            items(allBookmark.value){
                bookmark ->
                BookmarkItemScreen(navigateToDetailScreen = navigateToDetailScreen,deleteBookmark, bookmark = bookmark)
            }
        }

    }
}