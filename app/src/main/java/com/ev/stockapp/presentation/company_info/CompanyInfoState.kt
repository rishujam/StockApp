package com.ev.stockapp.presentation.company_info

import com.ev.stockapp.domain.models.CompanyInfo
import com.ev.stockapp.domain.models.IntradayInfo

data class CompanyInfoState(
    val stockInfos: List<IntradayInfo> = emptyList(),
    val company: CompanyInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)