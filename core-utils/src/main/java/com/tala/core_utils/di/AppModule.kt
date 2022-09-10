package com.tala.core_utils.di

import com.tala.core_utils.utils.AppDispatchers
import com.tala.core_utils.utils.AppDispatchersImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDispatchers(): AppDispatchers = AppDispatchersImpl()
}