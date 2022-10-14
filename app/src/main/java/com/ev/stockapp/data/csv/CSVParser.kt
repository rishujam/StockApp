package com.ev.stockapp.data.csv

import com.ev.stockapp.domain.models.CompanyListing
import com.ev.stockapp.domain.models.IntradayInfo
import java.io.InputStream

interface CSVParser<T> {

    suspend fun parse(stream: InputStream): List<T>
}