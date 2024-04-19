package com.example.news_main

import com.example.news.data.ArticleRepository
import com.example.news.data.RequestResult
import com.example.news.data.map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import com.example.news.data.model.Article as DataArticle

internal class GetArticleUseCase(private val repository: ArticleRepository){

    operator fun invoke(): Flow<RequestResult<List<ArticleUI>>> {
         return repository.getAll()
             .map { requestResult -> requestResult.map {articles ->
                 articles.map { it.toUiArticle() }
                  }
             }
    }
}

private fun DataArticle.toUiArticle(): ArticleUI {
    TODO("not impl")
}