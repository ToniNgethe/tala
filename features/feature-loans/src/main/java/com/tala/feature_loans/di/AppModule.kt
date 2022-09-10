package com.tala.feature_loans.di

import com.tala.core_data.domain.DataSource
import com.tala.feature_loans.data.LoanRepositoryImpl
import com.tala.feature_loans.domain.LoansRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLoanRepository(dataSource: DataSource): LoansRepository =
        LoanRepositoryImpl(dataSource)

}