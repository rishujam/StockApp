package com.ev.stockapp.data.csv

import com.ev.stockapp.domain.models.CompanyListing
import java.io.InputStream

interface CSVParser<T> {

    suspend fun parse(stream: InputStream): List<CompanyListing>
}