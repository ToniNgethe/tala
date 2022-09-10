package com.tala.core_data.di

import android.content.Context
import com.tala.core_data.data.DataSourceImpl
import com.tala.core_data.domain.DataSource
import com.tala.core_utils.utils.AppDispatchers
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @OptIn(ExperimentalSerializationApi::class)
    @Provides
    @Singleton
    fun provideKotlinJson() = Json {
        ignoreUnknownKeys
        explicitNulls = false
    }

    @Provides
    @Singleton
    fun provideDataSource(
        @ApplicationContext context: Context, json: Json, appDispatchers: AppDispatchers
    ): DataSource = DataSourceImpl(context, json, appDispatchers)

}