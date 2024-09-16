package com.example.newslistapp.domain

interface INewsRepository {
    suspend fun getNews(): List<NewsModel>
}
