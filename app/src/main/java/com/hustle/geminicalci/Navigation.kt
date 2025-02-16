package com.hustle.geminicalci

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

sealed class Screen(val route: String){
    data object Calculator: Screen("calculator")
//    data object Camera: Screen("camera")
}
@Composable
fun NavController() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Calculator.route) {
        composable(Screen.Calculator.route) {
            CalculatorScreen(navController)
        }
//        composable(Screen.Camera.route) {
//            CameraScreen(navController=navController)
//        }
    }
}
