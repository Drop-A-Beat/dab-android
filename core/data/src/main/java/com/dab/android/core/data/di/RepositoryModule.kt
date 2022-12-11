package com.dab.android.core.data.di

import com.dab.android.core.data.datasource.DabDataSource
import com.dab.android.core.data.repository.AlbumRepositoryImpl
import com.dab.android.core.domain.repository.AlbumRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by WonSeok on 2022.08.02
 **/
@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providesAlbumRepository(dabDataSource: DabDataSource): AlbumRepository {
        return AlbumRepositoryImpl(dabDataSource)
    }
}