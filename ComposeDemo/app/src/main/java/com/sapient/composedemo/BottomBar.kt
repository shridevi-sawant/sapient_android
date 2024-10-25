package com.sapient.composedemo

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon

import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue



@Composable
fun BottomBarSetup() {
    var selectedItem by remember { mutableStateOf("home")}

    val navController = LocalNavController.current

    BottomAppBar {
        NavigationBarItem(selected = selectedItem == "home", onClick = {

            if (!navController.popBackStack("home", false))
                navController.navigate("home")

            selectedItem = "home"
        }, icon = {
            Icon(imageVector = Icons.Default.Home, contentDescription = "")
        })

        NavigationBarItem(selected = selectedItem == "profile", onClick = {
            if (!navController.popBackStack("profile", false))
                navController.navigate("profile")

            selectedItem = "profile"
        }, icon = {
            Icon(imageVector = Icons.Default.Person, contentDescription = "")
        })

        NavigationBarItem(selected = selectedItem == "list", onClick = {
            if (!navController.popBackStack("list", false))
                navController.navigate("list")

            selectedItem = "list"
        }, icon = {
            Icon(imageVector = Icons.Default.ShoppingCart,
                contentDescription = "")
        })
    }
}