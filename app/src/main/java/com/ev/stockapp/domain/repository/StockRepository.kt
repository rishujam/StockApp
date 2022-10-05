package com.ev.stockapp.domain.repository

import com.ev.stockapp.domain.models.CompanyListing
import com.ev.stockapp.util.Resource
import kotlinx.coroutines.flow.Flow

interface StockRepository {

    suspend fun getCompanyListing(
        fetchFromRemote: Boolean,
        query:String
    ): Flow<Resource<List<CompanyListing>>>
}