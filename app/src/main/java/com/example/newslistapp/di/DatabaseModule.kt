package com.example.newslistapp.di

import android.content.Context
import androidx.room.Room
import com.example.newslistapp.data.database.NewsDao
import com.example.newslistapp.data.database.NewsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(@ApplicationContext appContext: Context): NewsDatabase {
        return Room.databaseBuilder(
            appContext,
            NewsDatabase::class.java,
            "news_database"
        ).build()
    }

    @Provides
    fun provideNewsDao(db: NewsDatabase): NewsDao {
        return db.newsDao()
    }
}