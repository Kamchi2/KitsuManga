package com.example.kitsumanga.di

import com.example.kitsumanga.data.remote.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideMangaApiService(retrofitClient: RetrofitClient) = retrofitClient.provideMangaApiService()

    @Singleton
    @Provides
    fun provideRetrofitClient() = RetrofitClient()

}