package com.dab.android.core.data.di

import com.dab.android.core.data.datasource.DabDataSource
import com.dab.android.core.data.datasource.DabDataSourceImpl
import com.dab.android.core.data.service.DabService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideDabDataSource(
        abandonedPetsService: DabService
    ): DabDataSource {
        return DabDataSourceImpl(abandonedPetsService)
    }
}