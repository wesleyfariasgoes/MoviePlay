package com.wfghc.marvelapp.framework.di

import com.wfghc.marvelapp.framework.network.AuthorizationInterceptor
import com.wfghc.marvelapp.BuildConfig
import com.wfghc.marvelapp.framework.network.MarvelApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.Calendar
import java.util.TimeZone
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val TIMEOUT_SECOND = 15L

    @Provides
    fun provideLogginInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            setLevel(
                if (BuildConfig.DEBUG) {
                    HttpLoggingInterceptor.Level.BODY
                } else {
                    HttpLoggingInterceptor.Level.NONE
                }
            )
        }
    }

    @Provides
    fun providesAuthorizationInterceptor() : AuthorizationInterceptor {
        return AuthorizationInterceptor(
            publicKey = BuildConfig.PUBLIC_KEY,
        privateKey = BuildConfig.PRIVATE_KEY,
            calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
        )
    }

    @Provides
    fun provideOkHttpClient (
        loggingInterceptor: HttpLoggingInterceptor,
        authorizationInterceptor: AuthorizationInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(authorizationInterceptor)
            .readTimeout(TIMEOUT_SECOND, TimeUnit.SECONDS)
            .connectTimeout(TIMEOUT_SECOND, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    fun provideGsonCoverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        converterFactory: GsonConverterFactory
    ): MarvelApi {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(converterFactory)
            .build()
            .create(MarvelApi::class.java)
    }
}