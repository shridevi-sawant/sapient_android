package com.sapient.composedemo

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {

    // step 1 - navigation controller - navigate(), popBackStack()

    // navigation graph, start destination

    val navController = LocalNavController.current

    NavHost(navController = navController as NavHostController,
        startDestination = "home" ){

        composable("home"){
            Greeting(name = "Sapient", modifier = modifier)
        }

        composable("profile"){

            LoginScreen(modifier = modifier)
        }

        composable("list"){
            StudentScreen(modifier = modifier)
        }
    }

}