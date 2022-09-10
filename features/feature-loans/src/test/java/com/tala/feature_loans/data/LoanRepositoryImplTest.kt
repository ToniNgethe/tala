package com.tala.feature_loans.data

import com.google.common.truth.Truth
import com.tala.core_data.domain.DataSource
import com.tala.core_data.domain.models.Loan
import com.tala.core_data.domain.models.LoanStatus
import com.tala.core_utils.utils.ReturnState
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class LoanRepositoryImplTest {
    private lateinit var dataSource: DataSource
    private lateinit var loansRepositoryImpl: LoanRepositoryImpl

    @Before
    fun setUp() {
        dataSource = mockk()
        loansRepositoryImpl = LoanRepositoryImpl(dataSource)
    }

    @Test
    fun `should return a success state with list of loans given a datasource`() = runTest {
        // given
        val sampleLoans = listOf(
            Loan(
                locale = "ke",
                loanStatus = LoanStatus.APPROVED,
                amount = 100,
                formattedAmount = "100",
                dueDate = "Today",
                date = null,
                name = null,
                icon = 0,
                localeData = null,
                storyCard = 1
            )
        )
        // when
        coEvery { dataSource.fetchLoans() } returns sampleLoans

        // assert
        val loansState = loansRepositoryImpl.fetchLoans()
        Truth.assertThat(loansState).isInstanceOf(ReturnState.SuccessState::class.java)
        Truth.assertThat((loansState as ReturnState.SuccessState).data).isEqualTo(sampleLoans)
    }

    @Test
    fun `should return a failed state given an exception occurs`() = runTest {
        // when
        coEvery { dataSource.fetchLoans() } throws Exception("Unable to fetch loans")
        // assert
        val loansState = loansRepositoryImpl.fetchLoans()
        Truth.assertThat(loansState).isInstanceOf(ReturnState.ErrorState::class.java)
    }
}