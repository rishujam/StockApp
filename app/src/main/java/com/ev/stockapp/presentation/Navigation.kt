package com.ev.stockapp.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ev.stockapp.presentation.company_info.CompanyInfoScreen
import com.ev.stockapp.presentation.company_listing.CompanyListingScreen

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.CompanyListings.route) {
        composable(route = Screen.CompanyListings.route) {
            CompanyListingScreen(navController = navController)
        }
        composable(
            route = Screen.CompanyInfo.route
//            arguments = listOf(
//                navArgument("name") {
//                    type = NavType.StringType
//                    defaultValue = "Rishu"
//                }
//            )
        ) {
            CompanyInfoScreen()
        }
    }
}