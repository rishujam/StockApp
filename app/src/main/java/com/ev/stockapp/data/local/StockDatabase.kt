package com.ev.stockapp.data.local

import androidx.room.Database
import com.ev.stockapp.data.local.CompanyListingEntity
import com.ev.stockapp.data.local.StockDao

@Database(
    entities = [CompanyListingEntity::class],
    version = 1
)
abstract class StockDatabase {

    abstract val dao: StockDao

}