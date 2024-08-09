package com.example.lokal_demo.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lokal_demo.model.Job
import com.example.lokal_demo.model.PrimaryDetails
import com.example.lokal_demo.navigation.Screens
import com.example.lokal_demo.presentation.components.hexToColor
import com.example.lokal_demo.viewModel.JobsScreenViewModel

@Composable
fun LokalAppDemo(
    navController : NavHostController
) {

    var selected by remember {
        mutableStateOf(Icons.Default.Email)
    }
    val jobScreenViewModel : JobsScreenViewModel = viewModel()
    val viewSate by jobScreenViewModel.jobState

    Scaffold (
        bottomBar = {
            BottomAppBar (contentColor = hexToColor("#76c893")) {

                IconButton(
                    onClick = {
                        selected = Icons.Default.Email
                        navController.navigate(Screens.JobsScreen.route){
                            popUpTo(0) }
                              },
                    modifier = Modifier.weight(1f)
                    ) {
                    Icon(Icons.Default.Email, contentDescription =null,
                        tint =  if (selected == Icons.Default.Email) Color.Gray else Color.White)
                }

                IconButton(
                    onClick = {
                        selected = Icons.Filled.Favorite
                        navController.navigate(Screens.BookmarkScreen.route){popUpTo(0)}
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(Icons.Filled.Favorite, contentDescription = "Bookmark icon", tint =
                    if ( selected == Icons.Filled.Favorite) Color.Gray else Color.White)
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
                    }
                )
            }

            composable(route = Screens.JobDetailScreen.route){
                val job =navController.previousBackStackEntry?.savedStateHandle?.
                    get<Job>("job") ?: Job("","",
                    PrimaryDetails("","","","","",""),
                    0f,0f,"","")
                JobDetailScreen(job = job)
            }

            composable(route = Screens.BookmarkScreen.route){
                BookmerksScreen()
            }
        }


    }
}