package com.tala.core_data.data

import android.content.Context
import com.tala.core_data.data.dto.LoanDtoItem
import com.tala.core_data.data.dto.LocaleDto
import com.tala.core_data.data.dto.toLoan
import com.tala.core_data.domain.DataSource
import com.tala.core_data.domain.models.Loan
import com.tala.core_data.domain.models.Locale
import com.tala.core_utils.utils.AppDispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import javax.inject.Inject


class DataSourceImpl @Inject constructor(
    private val context: Context, private val json: Json, private val appDispatchers: AppDispatchers
) : DataSource {

    fun getStringFromAsset(name: String): String = context.assets.open(name).bufferedReader().use {
        it.readText()
    }


    override suspend fun fetchLoans(): List<Loan> = withContext(appDispatchers.io()) {
        val assetJson = getStringFromAsset("testData.json")
        val loanList = json.decodeFromString<List<LoanDtoItem>>(assetJson)

        val localeData = fetchLocales()

        return@withContext loanList.map { loanData ->
            loanData.toLoan(localeData.find { it.name == loanData.locale })
        }
    }

    override suspend fun fetchLocales(): List<Locale> {
        val assetJson = getStringFromAsset("locales.json")
        val locales = json.decodeFromString<LocaleDto>(assetJson)
        return mutableListOf(
            Locale(
                "ke", locales.ke?.currency, locales.ke?.loanLimit, locales.ke?.timezone
            ), Locale(
                "mx", locales.mx?.currency, locales.mx?.loanLimit, locales.mx?.timezone
            ), Locale(
                "ph", locales.ph?.currency, locales.ph?.loanLimit, locales.ph?.timezone
            )
        )
    }

}