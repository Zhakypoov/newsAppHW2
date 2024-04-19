package com.example.news_main

import androidx.lifecycle.viewModelScope
import com.example.news.data.ArticleRepository
import com.example.news.data.RequestResult
import com.example.news.data.map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject
import com.example.news.data.model.Article as DataArticle

class GetArticleUseCase @Inject constructor(
    private val repository: ArticleRepository,
){

    operator fun invoke(): Flow<RequestResult<List<Article>>> {
         return repository.getAll()
             .map { requestResult -> requestResult.map {articles ->
                 articles.map { it.toUiArticle() }
                  }
             }
    }
}

private fun DataArticle.toUiArticle(): Article {
    TODO("not impl")
}