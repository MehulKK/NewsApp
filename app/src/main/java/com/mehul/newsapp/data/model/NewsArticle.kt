/*
 * *
 *  * Created by Mehul Kabaria on 21/04/2024, 10:30 AM
 *  * Copyright (c) 2024 . All rights reserved.
 *
 */

package com.mehul.newsapp.data.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(
    tableName = "news_articles"
)
data class NewsArticle(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    val author: String?,
    val content: String?,
    val description: String?,
    var publishedAt: String?,
    val source: Source?,
    val title: String?,
    val url: String?,
    val urlToImage: String?
) : Serializable