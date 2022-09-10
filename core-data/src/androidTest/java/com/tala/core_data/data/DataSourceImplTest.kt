package com.tala.core_data.data

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth
import com.tala.core_utils.utils.AppDispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class DataSourceImplTest {

    private lateinit var dataSourceImpl: DataSourceImpl
    private lateinit var json: Json
    private lateinit var appDispatchers: AppDispatchers
    private val testContext: Context = ApplicationProvider.getApplicationContext()

    @get:Rule
    val coroutineRule = CustomCoroutineRule()

    @OptIn(ExperimentalSerializationApi::class)
    @Before
    fun setUp() {
        json = Json {
            ignoreUnknownKeys
            explicitNulls = false
        }
        appDispatchers = TestAppDispatchers()

        dataSourceImpl =
            DataSourceImpl(testContext, json, appDispatchers)
    }

    @Test
    fun shouldReturnStringFromAsset() = runTest {
        val stringFromJson = dataSourceImpl.getStringFromAsset("locales.json")

        Truth.assertThat(stringFromJson).contains("ke")
        Truth.assertThat(stringFromJson).contains("mx")
        Truth.assertThat(stringFromJson).contains("ph")
    }

    @Test
    fun shouldReturnListOfLoansFromJsonFile() = runTest {
        val loans = dataSourceImpl.fetchLoans()
        Truth.assertThat(loans).isNotEmpty()
    }

    @Test
    fun shouldReturnListOfLoansWithCorrectMappedLocale() = runTest {
        val loans = dataSourceImpl.fetchLoans()
        Truth.assertThat(loans[0].locale).isEqualTo(loans[0].localeData?.name)
    }

    @Test
    fun shouldReturnListOfLocalesFromJsonFile() = runTest {
        val locales = dataSourceImpl.fetchLocales()

        Truth.assertThat(locales).isNotEmpty()
        Truth.assertThat(locales.size).isEqualTo(3)
    }
}