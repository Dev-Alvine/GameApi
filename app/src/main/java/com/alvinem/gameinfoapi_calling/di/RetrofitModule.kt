package com.alvinem.gameinfoapi_calling.di

import com.alvinem.gameinfoapi_calling.data.remote.GameApi
import com.alvinem.gameinfoapi_calling.util.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent ::class)
object RetrofitModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun  provideGameApi(retrofit: Retrofit): GameApi{
        return retrofit.create(GameApi::class.java)
    }


}