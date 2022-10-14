package com.ev.stockapp.domain.models

import com.squareup.moshi.Json

data class CompanyInfo(
    val symbol:String,
    val description:String,
    val name:String,
    val country:String,
    val industry:String,
)