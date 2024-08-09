package com.example.lokal_demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.lokal_demo.presentation.LokalAppDemo
import com.example.lokal_demo.ui.theme.Lokal_DemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            Lokal_DemoTheme {

//                val navController = rememberNavController()
//                NavHost(navController = navController, startDestination = Screens.JobsScreen.route){
//                    composable(route = Screens.JobsScreen.route){
//                        JobsScreen(
//                            navigateToDetailScreen = {
//                                navController.currentBackStackEntry?.savedStateHandle?.set("job",it)
//                                navController.navigate(Screens.JobDetailScreen.route)
//                            }
//                        )
//                    }
//
//                    composable(route = Screens.JobDetailScreen.route){
//                        val job =navController.previousBackStackEntry?.savedStateHandle?.
//                            get<Jobs>("job") ?: Jobs( "","","",0f,0f,"")
//                        JobDetailScreen(job = job)
//                    }
//                }

                LokalAppDemo(navController = navController)
            }
        }
    }
}
