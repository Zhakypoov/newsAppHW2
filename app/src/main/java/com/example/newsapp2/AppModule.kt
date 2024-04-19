package com.example.newsapp2

import android.content.Context
import com.example.database.NewsDatabase
import com.example.news.common.AppDispatchers

import com.example.newsapi.NewsApi
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
    fun providerNewsApi(): NewsApi{
       return NewsApi(
           baseUrl = BuildConfig.NEWS_API_BASE_URL,
           apiKey = BuildConfig.NEWS_API_KEY
       )
    }

    @Provides
    @Singleton
    fun providerNewsDatabase(@ApplicationContext context: Context): NewsDatabase{
        return NewsDatabase(context)
    }

    @Provides
    @Singleton
    fun providerAppCoroutineDispatchers(): AppDispatchers = AppDispatchers()
}