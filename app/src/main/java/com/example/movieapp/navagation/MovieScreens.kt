package com.example.movieapp.navagation

//www.google.com/sign_in
enum class MovieScreens {
    HomeScreen,
    DetailsScrren;
    companion object{
        fun fromRoute(route: String?): MovieScreens
        =when (route?.substringBefore("/")){
            HomeScreen.name->HomeScreen
            DetailsScrren.name->DetailsScrren
        null ->HomeScreen
        else -> throw IllegalArgumentException("Route $route is not recognized")
        }

    }
}