package com.example.newslistapp.data

import com.example.newslistapp.domain.NewsModel
import retrofit2.http.GET

interface NewsApi {
    @GET("news")
    suspend fun getNews(): List<NewsModel>
}
