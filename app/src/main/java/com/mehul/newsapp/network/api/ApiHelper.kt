/*
 * *
 *  * Created by Mehul Kabaria on 21/04/2024, 10:30 AM
 *  * Copyright (c) 2024 . All rights reserved.
 *
 */

package com.mehul.newsapp.network.api

import com.mehul.newsapp.data.model.NewsResponse
import retrofit2.Response

interface ApiHelper {
    suspend fun searchNews(query: String, pageNumber: Int): Response<NewsResponse>
    suspend fun getNews(countryCode: String, pageNumber: Int): Response<NewsResponse>
}