package com.ev.stockapp.presentation.company_listing

import com.ev.stockapp.domain.models.CompanyListing

data class CompanyListingsState(
    val companies:List<CompanyListing> = emptyList(),
    val isLoading:Boolean = false,
    val isRefreshing:Boolean = false,
    val searchQuery:String=""
)
