package com.example.lokal_demo.navigation

sealed class Screens (val route : String) {
    object JobsScreen :Screens(route = "jobsScreen")
    object JobDetailScreen : Screens(route = "jobDetailScreen")
    object BookmarkScreen : Screens(route = "bookmarkScreen")
    object BookmarkJobDetailScreen :Screens(route = "bookmarkJobDetailScreen")

}