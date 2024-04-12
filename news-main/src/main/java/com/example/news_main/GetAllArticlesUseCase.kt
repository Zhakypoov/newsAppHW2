package com.example.news_main

import com.example.news.data.ArticleRepository
import com.example.news.data.RequestResult
import com.example.news.data.model.Article
import kotlinx.coroutines.flow.Flow

class GetAllArticlesUseCase(private val repository: ArticleRepository) {
    operator fun invoke(): RequestResult<Flow<List<Article>>> {
        return repository.getAll()
    }
}