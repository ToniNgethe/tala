package com.tala.feature_loans.presentation

import app.cash.turbine.test
import com.google.common.truth.Truth
import com.tala.core_data.domain.models.Loan
import com.tala.core_data.domain.models.LoanStatus
import com.tala.core_utils.utils.ReturnState
import com.tala.feature_loans.CustomCoroutineRule
import com.tala.feature_loans.domain.LoansRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class LoansVmTest {

    private lateinit var loansRepository: LoansRepository
    private lateinit var loansVm: LoansVm

    @get:Rule
    val customCoroutineRule = CustomCoroutineRule(StandardTestDispatcher())

    @Before
    fun setUp() {
        loansRepository = mockk()
        loansVm = LoansVm(loansRepository)
    }

    @Test
    fun `should update ui state when loading`() = runTest {
        coEvery { loansRepository.fetchLoans() } returns ReturnState.SuccessState(listOf())
        loansVm.loanUiState.test {
            Truth.assertThat(awaitItem().isLoading).isTrue()
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `should update ui with list of loans given request was a success`() = runTest {
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
        coEvery { loansRepository.fetchLoans() } returns ReturnState.SuccessState(sampleLoans)
        // act
        loansVm.loanUiState.test {
            awaitItem()
            val update = awaitItem()

            Truth.assertThat(update.isLoading).isFalse()
            Truth.assertThat(update.loans).isEqualTo(sampleLoans)

            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `should update ui state with an error given an exception occurs`() = runTest {
        // when
        coEvery { loansRepository.fetchLoans() } returns ReturnState.ErrorState("Something went wrong")
        // assert
        loansVm.loanUiState.test {
            awaitItem()
            val update = awaitItem()

            Truth.assertThat(update.isLoading).isFalse()
            Truth.assertThat( update.errorMessage ).isEqualTo( "Something went wrong" )
        }
    }
}