package com.tala.core_data.domain

import com.tala.core_data.domain.models.Loan
import com.tala.core_data.domain.models.Locale

interface DataSource {
    suspend fun fetchLoans(): List<Loan>
    suspend fun fetchLocales( ) : List<Locale>
}