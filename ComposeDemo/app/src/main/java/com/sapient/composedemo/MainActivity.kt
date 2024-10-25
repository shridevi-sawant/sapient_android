package com.sapient.composedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.sapient.composedemo.ui.theme.ComposeDemoTheme
import kotlinx.coroutines.launch

val LocalNavController = compositionLocalOf<NavController> {
    error("No NavController found!")
}

val LocalSnackBarHostState = compositionLocalOf<SnackbarHostState> {
    error("No host state found!")
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            ComposeDemoTheme {
                val navController = rememberNavController()
                
                val snackbarHostState = remember {
                    SnackbarHostState()
                }

                val scope = rememberCoroutineScope()

                CompositionLocalProvider(LocalSnackBarHostState provides snackbarHostState) {


                    CompositionLocalProvider(LocalNavController provides navController) {
                        Scaffold(modifier = Modifier.fillMaxSize(),
                            snackbarHost = {
                                SnackbarHost(hostState = snackbarHostState)
                            },
                            floatingActionButton = {
                                FloatingActionButton(onClick = {
                                    scope.launch {
                                        snackbarHostState.showSnackbar("fab clicked")
                                    }

                                }) {
                                    Icon(
                                        imageVector = Icons.Default.Add,
                                        contentDescription = ""
                                    )
                                }
                            },
                            topBar = {
                                TopBarSetup()
                            },
                            bottomBar = {
                                BottomBarSetup()
                            }

                        ) { innerPadding ->
//
                            AppNavigation(modifier = Modifier.padding(innerPadding))
                        }
                    }

                    //StudentScreen(modifier = Modifier.padding(innerPadding))
                    //LoginScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp)
            .background(Color.Gray)
    ) {
        Text(
            color = Color.Magenta,
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            text = "Good morning $name!",
            modifier = modifier
                .align(Alignment.TopEnd)
                .padding(8.dp)
                .background(Color.Cyan)


        )

        Text(text = "Android", modifier = Modifier.align(Alignment.Center))
        Text(text = "iOS", modifier = Modifier.align(Alignment.BottomStart))
        Text(text = "Flutter")
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    ComposeDemoTheme {
        Greeting("Android")
    }
}