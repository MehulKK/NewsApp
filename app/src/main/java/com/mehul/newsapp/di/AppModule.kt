/*
 * *
 *  * Mehul Kabaria on 21/04/2024, 10:30 AM
 *  * Copyright (c) 2022 . All rights reserved.
 *
 */

package com.mehul.newsapp.di

import android.content.Context
import com.mehul.newsapp.NewsApp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): NewsApp {
        return app as NewsApp
    }

}