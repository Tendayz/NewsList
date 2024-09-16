package com.example.newslistapp.data

import com.example.newslistapp.domain.NewsModel

class MockNewsApi : NewsApi {
    override suspend fun getNews(): List<NewsModel> {
        return listOf(
            NewsModel(1, "New Update", "11 февраля 2024", "url_to_image_1"),
            NewsModel(2, "New Update", "11 февраля 2024", "url_to_image_1"),
            NewsModel(3, "New Update", "11 февраля 2024", "url_to_image_1"),
            NewsModel(4, "New Update", "11 февраля 2024", "url_to_image_1"),
            NewsModel(5, "Another Update", "11 июня 2024", "url_to_image_2"),
            NewsModel(6, "Another Update", "11 июня 2024", "url_to_image_2"),
            NewsModel(7, "Another Update", "11 июня 2024", "url_to_image_2"),
            NewsModel(8, "Another Update", "11 июня 2024", "url_to_image_2"),
            NewsModel(9, "Another Update", "11 июня 2024", "url_to_image_3"),
            NewsModel(10, "Another Update", "11 июня 2024", "url_to_image_3"),
            NewsModel(11, "Another Update", "11 июня 2024", "url_to_image_3"),
            NewsModel(12, "Another Update", "11 июня 2024", "url_to_image_3"),
        )
    }
}
