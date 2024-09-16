package com.example.newslistapp.presentation.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.newslistapp.domain.NewsModel
import com.example.newslistapp.presentation.screen.components.ListItem
import com.example.newslistapp.presentation.viewmodel.NewsViewModel

@Composable
fun NewsListScreen(newsViewModel: NewsViewModel = hiltViewModel<NewsViewModel>()) {
    val newsList: List<NewsModel> by newsViewModel.newsList.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 32.dp)
    ) {
        itemsIndexed(newsList.chunked(4)) { _, items ->
            ListItem(items)
        }
    }
}
