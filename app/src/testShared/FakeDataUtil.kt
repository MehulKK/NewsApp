/*
 * *
 *  * Created by Mehul Kabaria on 21/04/2024, 10:30 AM
 *  * Copyright (c) 2024 . All rights reserved.
 *
 */

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mehul.newsapp.data.model.NewsArticle
import com.mehul.newsapp.data.model.NewsResponse
import com.mehul.newsapp.data.model.Source
import com.mehul.newsapp.state.NetworkState

object FakeDataUtil {
    fun getFakeNewsArticleResponse(): NetworkState<NewsResponse> {
        val articles = getFakeArticles()
        val newsResponse = NewsResponse(
            articles = articles, "200", 2
        )
        return NetworkState.Success(newsResponse)
    }

    fun getFakeNewsArticleLiveData(): LiveData<List<NewsArticle>> {
        val list = MutableLiveData<List<NewsArticle>>()
        val result: LiveData<List<NewsArticle>> = list
        list.postValue(getFakeArticles())
        return result
    }

    fun getFakeArticles(): MutableList<NewsArticle> {
        val articleList: MutableList<NewsArticle> = arrayListOf()
        val source1 = Source(
            id = 1, name = "BBC"
        )
        val article1 = NewsArticle(
            id = 1, author = "A", content = "ABC", description = "Desc1", publishedAt = "",
            source = source1, title = "Title1", url = "https://google.com", urlToImage = ""
        )
        val source2 = Source(
            id = 2, name = "CNN"
        )
        val article2 = NewsArticle(
            id = 2, author = "B", content = "DEF", description = "Desc2", publishedAt = "",
            source = source2, title = "Title2", url = "https://youtube.com", urlToImage = ""
        )

        articleList.add(article1)
        articleList.add(article2)
        return articleList
    }

    fun getFakeArticle(): NewsArticle {
        val source1 = Source(
            id = 1, name = "BBC"
        )
        val article1 = NewsArticle(
            id = 1, author = "A", content = "ABC", description = "Desc1", publishedAt = "",
            source = source1, title = "Title1", url = "https://google.com", urlToImage = ""
        )
        return article1
    }
}