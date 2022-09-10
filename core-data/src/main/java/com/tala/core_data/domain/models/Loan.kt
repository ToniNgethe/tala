package com.tala.core_data.domain.models

@kotlinx.serialization.Serializable
data class Loan(
    val locale: String?,
    val loanStatus: LoanStatus?,
    val amount: Int?,
    val formattedAmount: String? = null,
    val dueDate: String? = null,
    val date: String?,
    val name: String?,
    val icon: Int,
    val localeData: Locale?,
    val storyCard: Int
)
