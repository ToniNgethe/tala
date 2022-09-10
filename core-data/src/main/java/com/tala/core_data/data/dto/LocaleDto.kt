package com.tala.core_data.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LocaleDto(
    @SerialName("ke")
    val ke: Ke?,
    @SerialName("mx")
    val mx: Mx?,
    @SerialName("ph")
    val ph: Ph?
) {
    @Serializable
    data class Ke(
        @SerialName("currency")
        val currency: String?,
        @SerialName("loanLimit")
        val loanLimit: Int?,
        @SerialName("timezone")
        val timezone: Int?
    )

    @Serializable
    data class Mx(
        @SerialName("currency")
        val currency: String?,
        @SerialName("loanLimit")
        val loanLimit: Int?,
        @SerialName("timezone")
        val timezone: Int?
    )

    @Serializable
    data class Ph(
        @SerialName("currency")
        val currency: String?,
        @SerialName("loanLimit")
        val loanLimit: Int?,
        @SerialName("timezone")
        val timezone: Int?
    )
}