package com.tala.feature_loans.data

import com.tala.core_data.domain.DataSource
import com.tala.core_data.domain.models.Loan
import com.tala.core_utils.utils.ReturnState
import com.tala.feature_loans.domain.LoansRepository
import javax.inject.Inject

class LoanRepositoryImpl @Inject constructor(private val dataSource: DataSource) : LoansRepository {
    override suspend fun fetchLoans(): ReturnState<List<Loan>> = try {
        val loans = dataSource.fetchLoans()
        ReturnState.SuccessState(loans)
    } catch (e: Exception) {
        ReturnState.ErrorState("Unable to fetch loans at the moment")
    }

}