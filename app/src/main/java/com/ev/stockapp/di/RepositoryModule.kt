package com.ev.stockapp.di

import com.ev.stockapp.data.csv.CSVParser
import com.ev.stockapp.data.csv.CompanyListingParser
import com.ev.stockapp.data.repository.StockRepositoryImpl
import com.ev.stockapp.domain.models.CompanyListing
import com.ev.stockapp.domain.repository.StockRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCompanyListingParser(
        companyListingParser: CompanyListingParser
    ): CSVParser<CompanyListing>

    @Binds
    @Singleton
    abstract fun bindStockRepository(
        stockRepositoryImpl: StockRepositoryImpl
    ): StockRepository
}