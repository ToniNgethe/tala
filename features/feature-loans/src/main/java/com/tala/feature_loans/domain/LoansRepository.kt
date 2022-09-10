package com.tala.feature_loans.domain

import com.tala.core_data.domain.models.Loan
import com.tala.core_utils.utils.ReturnState

interface LoansRepository {
    suspend fun fetchLoans(): ReturnState<List<Loan>>
}