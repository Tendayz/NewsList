package com.example.newslistapp.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news_table")
data class NewsEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val date: String,
    val imageUrl: String
)
