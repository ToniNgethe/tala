package com.tala.core_data.domain.models

@kotlinx.serialization.Serializable
data class Locale(
    var name: String?,
    var currency: String?,
    var loanLimit: Int?,
    var timeZone: Int?
)