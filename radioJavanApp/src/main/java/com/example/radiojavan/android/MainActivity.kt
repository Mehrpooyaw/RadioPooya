package com.example.radiojavan.android

import android.os.Bundle
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.radiojavan.android.presentation.search.SearchView
import com.example.radiojavan.android.presentation.track.TrackView
import com.google.accompanist.systemuicontroller.rememberSystemUiController


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val uiController = rememberSystemUiController()

            NavHost(navController = navController, startDestination = "search") {
            composable("track/{id}", arguments = listOf(navArgument("id"){
                type = NavType.IntType
            }), ) { nav ->
                val backgroundColor = MaterialTheme.colors.primary

                val arguments = requireNotNull(nav.arguments)
                val id = arguments.getInt("id")
                TrackView(colorCallBack = {
                    uiController.setStatusBarColor(it)
                }, id = id,onBackClicked = {
                    uiController.setStatusBarColor(backgroundColor)
                    navController.navigate("search")
                }
                )
            }
                composable("search") {

                    SearchView(modifier = Modifier, navigateToMusicScreen = {
                        navController.navigate("track/$it")
                    })
                }
        }

        }
    }
}
