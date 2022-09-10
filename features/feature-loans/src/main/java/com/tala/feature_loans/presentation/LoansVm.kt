package com.tala.feature_loans.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tala.core_data.domain.models.Loan
import com.tala.core_utils.utils.ReturnState
import com.tala.feature_loans.domain.LoansRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class LoansUiState(
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val loans: List<Loan> = listOf()
)

@HiltViewModel
class LoansVm @Inject constructor(private val loansRepository: LoansRepository) : ViewModel() {
    private val _loansUiState = MutableStateFlow(LoansUiState())
    val loanUiState = _loansUiState.asStateFlow()

    init {
        fetchLoans()
    }

    private fun fetchLoans() {
        _loansUiState.update { it.copy(isLoading = true, errorMessage = null, loans = emptyList()) }
        viewModelScope.launch {
            when (val response = loansRepository.fetchLoans()) {
                is ReturnState.SuccessState -> {
                    _loansUiState.update {
                        it.copy(
                            isLoading = false, errorMessage = null, loans = response.data
                        )
                    }
                }
                is ReturnState.ErrorState -> {
                    _loansUiState.update {
                        it.copy(
                            isLoading = false, errorMessage = response.message
                        )
                    }
                }
            }
        }
    }
}