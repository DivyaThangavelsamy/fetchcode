package com.example.fetchcode.di

import android.content.Context
import android.content.SharedPreferences
import com.example.fetchcode.data.api.FetchResponseCodeRepository
import com.example.fetchcode.data.api.Constants
import com.example.fetchcode.data.api.Webservice
import com.example.fetchcode.utils.SharedPreferenceManager
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL).build()
    }

    @Provides
    @Singleton
    fun provideWebservice(retrofit: Retrofit): Webservice {
        return retrofit.create(Webservice::class.java)
    }

    @Provides
    fun provideFetchCodeRepository(webservice: Webservice): FetchResponseCodeRepository {
        return FetchResponseCodeRepository(webservice)
    }

    @Provides
    @Singleton
    fun provideSharedPreference(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("pref_fetch_code", Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun provideSharedPreferenceManager(sharedPreferences: SharedPreferences): SharedPreferenceManager {
        return SharedPreferenceManager(sharedPreferences)
    }
}