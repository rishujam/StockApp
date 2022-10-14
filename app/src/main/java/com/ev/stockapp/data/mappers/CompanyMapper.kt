package com.ev.stockapp.data.mappers

import com.ev.stockapp.data.local.CompanyListingEntity
import com.ev.stockapp.data.remote.dto.CompanyInfoDto
import com.ev.stockapp.domain.models.CompanyInfo
import com.ev.stockapp.domain.models.CompanyListing

fun CompanyListingEntity.toCompanyListing(): CompanyListing {
    return CompanyListing(
        name = name,
        symbol = symbol,
        exchange = exchange
    )
}

fun CompanyListing.toCompanyListingEntity(): CompanyListingEntity {
    return CompanyListingEntity(
        name = name,
        symbol = symbol,
        exchange = exchange
    )
}

fun CompanyInfoDto.toCompanyInfo(): CompanyInfo {
    return CompanyInfo(
        symbol = symbol ?: "",
        description = description ?: "",
        name = name ?: "",
        country = country ?: "",
        industry = industry ?: ""
    )
}