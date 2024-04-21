/*
 * *
 *  * Created by Mehul Kabaria on 21/04/2024, 10:30 AM
 *  * Copyright (c) 2024 . All rights reserved.
 *
 */

package com.mehul.newsapp.network.repository

import com.mehul.newsapp.data.local.NewsDao
import com.mehul.newsapp.data.model.NewsArticle
import com.mehul.newsapp.data.model.NewsResponse
import com.mehul.newsapp.network.api.ApiHelper
import com.mehul.newsapp.state.NetworkState
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val remoteDataSource: ApiHelper,
    private val localDataSource: NewsDao
) : INewsRepository {

    override suspend fun getNews(
        countryCode: String,
        pageNumber: Int
    ): NetworkState<NewsResponse> {
        return try {
            val response = remoteDataSource.getNews(countryCode, pageNumber)
            val result = response.body()
            if (response.isSuccessful && result != null) {
                NetworkState.Success(result)
            } else {
                NetworkState.Error("An error occurred")
            }
        } catch (e: Exception) {
            NetworkState.Error("Error occurred ${e.localizedMessage}")
        }
    }

    override suspend fun searchNews(
        searchQuery: String,
        pageNumber: Int
    ): NetworkState<NewsResponse> {
        return try {
            val response = remoteDataSource.searchNews(searchQuery, pageNumber)
            val result = response.body()
            if (response.isSuccessful && result != null) {
                NetworkState.Success(result)
            } else {
                NetworkState.Error("An error occurred")
            }
        } catch (e: Exception) {
            NetworkState.Error("Error occurred ${e.localizedMessage}")
        }
    }

    override suspend fun saveNews(news: NewsArticle) = localDataSource.upsert(news)

    override fun getSavedNews() = localDataSource.getAllNews()

    override suspend fun deleteNews(news: NewsArticle) = localDataSource.deleteNews(news)

    override suspend fun deleteAllNews() = localDataSource.deleteAllNews()
}