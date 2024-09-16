package com.example.newslistapp.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newslistapp.domain.INewsRepository
import com.example.newslistapp.domain.NewsModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsRepository: INewsRepository
) : ViewModel() {

    private val _newsList = MutableStateFlow<List<NewsModel>>(emptyList())
    val newsList: StateFlow<List<NewsModel>> = _newsList.asStateFlow()

    init {
        loadNews()
    }

    private fun loadNews() {
        viewModelScope.launch {
            runCatching {
                newsRepository.getNews()
            }.onSuccess { news ->
                _newsList.value = news
            }.onFailure {
                it.printStackTrace()
            }
        }
    }
}
