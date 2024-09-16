package com.example.newslistapp.presentation.screen.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.newslistapp.domain.NewsModel

@Composable
fun ListItem(items: List<NewsModel>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(horizontal = 15.dp)
    ) {
        items.forEach { item ->
            NewsItem(news = item, modifier = Modifier.weight(1f))
        }
    }
}
