package com.ev.stockapp.data.repository

import com.ev.stockapp.data.csv.CSVParser
import com.ev.stockapp.data.local.StockDatabase
import com.ev.stockapp.data.mappers.toCompanyListing
import com.ev.stockapp.data.mappers.toCompanyListingEntity
import com.ev.stockapp.data.remote.StockApi
import com.ev.stockapp.domain.models.CompanyListing
import com.ev.stockapp.domain.repository.StockRepository
import com.ev.stockapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StockRepositoryImpl @Inject constructor(
    val api: StockApi,
    val db: StockDatabase,
    val companyListingsParser: CSVParser<CompanyListing>
): StockRepository {

    private val dao = db.dao

    override suspend fun getCompanyListing(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<CompanyListing>>> {
        return flow {
            emit(Resource.Loading(true))
            val localListings = dao.searchCompanyListing(query)
            emit(Resource.Success(
                data = localListings.map { it.toCompanyListing() }
            ))
            val isDbEmpty = localListings.isEmpty() && query.isBlank()
            val shouldJustLoadFromCache = !isDbEmpty && !fetchFromRemote
            if(shouldJustLoadFromCache){
                emit(Resource.Loading(false))
                return@flow
            }
            val remoteListing = try {
                val response = api.getListings()
                companyListingsParser.parse(response.byteStream())
            } catch (e:IOException){
                e.printStackTrace()
                emit(Resource.Error("Couldn't load data"))
                null
            } catch (e:HttpException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load data"))
                null
            }
            remoteListing?.let { listing ->
                emit(Resource.Success(listing))
                emit(Resource.Loading(false))
                dao.clearCompanyListing()
                dao.insertCompanyListings(listing.map { it.toCompanyListingEntity() })
            }
        }
    }
}