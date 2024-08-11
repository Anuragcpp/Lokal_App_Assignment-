package com.example.lokal_demo.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.lokal_demo.data.Bookmark
import com.example.lokal_demo.model.Job
import com.example.lokal_demo.model.PrimaryDetails
import com.example.lokal_demo.navigation.Screens
import com.example.lokal_demo.presentation.components.hexToColor
import com.example.lokal_demo.viewModel.JobsScreenViewModel
import kotlinx.coroutines.launch

@Composable
fun LokalAppDemo(
    navController : NavHostController
) {

    var selected by remember {
        mutableStateOf(Icons.Default.Email)
    }
    val jobScreenViewModel : JobsScreenViewModel = viewModel()
    val viewSate by jobScreenViewModel.jobState
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold (
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        bottomBar = {

            BottomAppBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(hexToColor("#2C3E50"))
                    .heightIn(max = 75.dp)
                ,
                containerColor = hexToColor("#1d3557"),
                contentColor = Color.White,
                tonalElevation = 6.dp
            ) {
                IconButton(
                    onClick = {
                        selected = Icons.Default.Email
                        navController.navigate(Screens.JobsScreen.route) {
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {

                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Icon(
                            Icons.Default.Email,
                            contentDescription = "Jobs Screen",
                            tint = if (selected == Icons.Default.Email) Color.White else Color.Gray,
                            modifier = Modifier.size(
                                if (selected == Icons.Default.Email) 23.dp else 18.dp
                            )
                        )

                        Text(
                            text = "Jobs" ,
                            color =  if (selected == Icons.Default.Email) Color.White else Color.Gray,
                            style = MaterialTheme.typography.titleLarge.copy(
                                fontWeight = if (selected == Icons.Default.Email) FontWeight.Bold else FontWeight.Normal,
                                fontSize = if (selected == Icons.Default.Email) 15.sp else 10.sp
                            ),
                        )
                    }
                }

                IconButton(
                    onClick = {
                        selected = Icons.Filled.Favorite
                        navController.navigate(Screens.BookmarkScreen.route) {
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Column (
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Icon(
                            Icons.Filled.Favorite,
                            contentDescription = "Bookmark Screen",
                            tint = if (selected == Icons.Filled.Favorite) Color.White else Color.Gray,
                            modifier = Modifier.size(
                                if (selected == Icons.Filled.Favorite) 23.dp else 18.dp
                            )
                        )

                        Text(
                            text = "Bookmark",
                            color =  if (selected == Icons.Filled.Favorite) Color.White else Color.Gray,
                            style = MaterialTheme.typography.titleLarge.copy(
                                fontWeight = if (selected == Icons.Filled.Favorite) FontWeight.Bold else FontWeight.Normal,
                                fontSize = if (selected == Icons.Filled.Favorite) 15.sp else 10.sp
                            ),
                        )
                    }
                }

            }
        }
    ) { paddingValue ->


        NavHost(
            navController = navController,
            startDestination = Screens.JobsScreen.route,
            modifier = Modifier.padding(paddingValue)
        ){
            composable(route = Screens.JobsScreen.route){
                JobsScreen(
                    viewState = viewSate,
                    navigateToDetailScreen = {
                        navController.currentBackStackEntry?.savedStateHandle?.set("job",it)
                        navController.navigate(Screens.JobDetailScreen.route)
                    },
                    addData = {
                        job,message ->
                        jobScreenViewModel.addData(job)
                        scope.launch {
                            snackbarHostState.showSnackbar(
                                message,
                                actionLabel = "Clear",
                                duration = SnackbarDuration.Short
                            )
                        }
                    }
                )
            }

            composable(route = Screens.JobDetailScreen.route){
                val job =navController.previousBackStackEntry?.savedStateHandle?.
                    get<Job>("job") ?: Job("","",
                    PrimaryDetails("","","","","",""),
                    0f,0f,"","")

                val bookmark = job.let { jobScreenViewModel.jobToBookmark(job) }
                JobDetailScreen(
                    bookmark = bookmark,
                    backBtn = {
                        navController.navigateUp()
                    }
                    )
            }

            composable(route = Screens.BookmarkScreen.route){
                BookmerksScreen(
                    viewModel = jobScreenViewModel,
                    navigateToDetailScreen = {
                        navController.currentBackStackEntry?.savedStateHandle?.set("bookmark",it)
                        navController.navigate(Screens.BookmarkJobDetailScreen.route)
                    },
                    deleteBookmark = {
                        bookmark , message ->
                        jobScreenViewModel.deleteBookmark(bookmark)
                        scope.launch {
                            snackbarHostState.showSnackbar(
                                message,
                                actionLabel = "Clear",
                                duration = SnackbarDuration.Short
                            )
                        }
                    }
                )
            }

            composable(route = Screens.BookmarkJobDetailScreen.route){
                val bookmark = navController.previousBackStackEntry?.savedStateHandle?.
                get<Bookmark>("bookmark") ?:
                Bookmark(0L,"",0f,0f,"","","","","",
                    "","","")
                BookmarkJobDetailScreen(
                    bookmark = bookmark,
                    backBtn = {
                        navController.navigateUp()
                    }
                    )
            }
        }


    }
}