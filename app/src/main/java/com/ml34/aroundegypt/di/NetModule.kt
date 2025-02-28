package com.ml34.aroundegypt.di

import com.ml34.aroundegypt.data.api.IExperienceApis
import com.ml34.aroundegypt.data.util.ConstantLinks
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class NetModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(ConstantLinks.BASE_URL)
            .client(getOkHttpClient())
            .build()
    }

    @Singleton
    @Provides
    fun provideExperiencesAPIService(retrofit: Retrofit): IExperienceApis{
        return retrofit.create(IExperienceApis::class.java)
    }

    private fun getOkHttpClient() = OkHttpClient().newBuilder()
        .addInterceptor { chain ->
            val newUrl = chain.request().url
                .newBuilder()
                .build()

            val newRequest = chain.request()
                .newBuilder()
                .url(newUrl)
                .addHeader("Accept", "application/json")
                .build()
            chain.proceed(newRequest)
        }
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .connectTimeout(60L, TimeUnit.SECONDS)
        .readTimeout(60L, TimeUnit.SECONDS)
        .writeTimeout(60L, TimeUnit.SECONDS)
        .build()
}
