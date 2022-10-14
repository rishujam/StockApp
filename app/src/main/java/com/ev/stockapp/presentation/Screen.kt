package com.ev.stockapp.presentation

sealed class Screen(val route:String) {
    object CompanyListings:Screen("company_listings_screen")
    object CompanyInfo: Screen("company_info_screen")

    //add this test commit1
}