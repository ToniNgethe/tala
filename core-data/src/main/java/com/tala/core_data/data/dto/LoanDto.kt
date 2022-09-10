package com.tala.core_data.data.dto


import com.tala.core_data.domain.models.*
import com.tala.core_utils.utils.TimeUtils
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.text.DecimalFormat

@Serializable
data class LoanDtoItem(
    @SerialName("loan") val loan: Loan?,
    @SerialName("locale") val locale: String?,
    @SerialName("timestamp") val timestamp: Long?,
    @SerialName("username") val username: String?
) {
    @Serializable
    data class Loan(
        @SerialName("approved") val approved: Int?,
        @SerialName("due") val due: Int?,
        @SerialName("dueDate") val dueDate: Long?,
        @SerialName("level") val level: String?,
        @SerialName("status") val status: String?
    )
}

fun LoanDtoItem.toLoan(localeData: Locale?) = Loan(
    locale = locale,
    localeData = localeData,
    loanStatus = getLoanStatusFromString(loan?.status),
    formattedAmount = if (loan?.due != null || loan?.approved != null) DecimalFormat("###,###,###").format(
        loan.due ?: loan.approved
    ) else null,
    amount = loan?.due ?: loan?.approved,
    dueDate = if (loan?.dueDate != null) TimeUtils.parseDatFromLong(loan.dueDate) else null,
    date = TimeUtils.parseDatFromLong(timestamp!!),
    name = username,
    icon = getLoanLevelDrawable(loan?.level),
    storyCard = getStoryCardImage(locale)
)
