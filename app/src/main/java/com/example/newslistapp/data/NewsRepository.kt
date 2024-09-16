package com.example.newslistapp.data

import com.example.newslistapp.data.database.NewsDao
import com.example.newslistapp.data.database.NewsEntity
import com.example.newslistapp.domain.INewsRepository
import com.example.newslistapp.domain.NewsModel

class NewsRepository(
    private val newsApi: NewsApi,
    private val newsDao: NewsDao
) : INewsRepository {

    override suspend fun getNews(): List<NewsModel> {
        try {
            val newsFromApi = newsApi.getNews()

            newsDao.insertNews(newsFromApi.map { news ->
                NewsEntity(
                    id = news.id,
                    title = news.title,
                    date = news.date,
                    imageUrl = news.imageUrl
                )
            })

            return newsFromApi
        } catch (e: Exception) {
            return newsDao.getAllNews().map { entity ->
                NewsModel(
                    id = entity.id,
                    title = entity.title,
                    date = entity.date,
                    imageUrl = entity.imageUrl
                )
            }
        }
    }
}
