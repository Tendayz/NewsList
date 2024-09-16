package com.example.newslistapp.di

import com.example.newslistapp.data.NewsApi
import com.example.newslistapp.data.database.NewsDao
import com.example.newslistapp.data.NewsRepository
import com.example.newslistapp.domain.INewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideNewsRepository(api: NewsApi, dao: NewsDao): INewsRepository {
        return NewsRepository(api, dao)
    }
}
