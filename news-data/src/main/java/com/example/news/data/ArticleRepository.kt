package com.example.news.data

import android.view.inspector.PropertyMapper
import com.example.database.NewsDatabase
import com.example.database.models.ArticleDBO
import com.example.news.data.model.Article
import com.example.newsapi.NewsApi
import com.example.newsapi.models.mappers.ArticleDTO
import com.example.newsapi.models.ResponseDTO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.flow.onEach
import java.io.IOException

class ArticleRepository(
    private val database: NewsDatabase,
    private val api: NewsApi,
) {
    fun getAll(): Flow<RequestResult<List<Article>>> {
        val cachedAllArticles: Flow<RequestResult.Success<List<ArticleDBO>>> = getAllFromDatabase()


        val remoteArticles: Flow<RequestResult<*>> = getAllFromServer()


        cachedAllArticles.map {

        }
        return cachedAllArticles.combine(remoteArticles) {

        }
    }


    private fun getAllFromServer(): Flow<RequestResult<List<ArticleDBO>?>> {
        return flow { emit(api.everything()) }
            .map {result ->
                if(result.isSuccess){
                    val response: ResponseDTO<ArticleDTO> = result.getOrThrow()
                    RequestResult.Success(response.articles)
                }else{
                    RequestResult.Error(null)
                }
            }
            .filterIsInstance<RequestResult.Success<List<ArticleDTO>?>>()
            .map { requestResult: RequestResult.Success<List<ArticleDTO>?> ->
                requestResult.map { dtos -> dtos.map { articleDto -> articleDto.toArticleDbo() } }
            }.onEach { requestResult ->
            database.articlesDao.insert(requestResult.data)
            }
    }

    private fun getAllFromDatabase(): Flow<RequestResult.Success<List<ArticleDBO>>> {
        return database.articlesDao
            .getAll()
            .map { RequestResult.Success(it)}
    }

    suspend fun search(query: String): Flow<Article> {
        api.everything()
        TODO("Not implemented")
    }
}





sealed class RequestResult<E>(internal val data: E){
    class InProgress<E>(data: E) : RequestResult<E>(data)
    class Success<E>(data: E) : RequestResult<E>(data)
    class Error<E>(data: E) : RequestResult<E>(data)
}


internal fun <T: Any> RequestResult<T?>.requireData(): T = checkNotNull(data)

internal fun <I, O> RequestResult<I?>.map(mapper: (I) -> O): RequestResult<O?> {
    val outData = mapper(data)
    return when(this){
        is RequestResult.Success -> RequestResult.Success(outData)
        is RequestResult.Error -> RequestResult.Error(outData)
        is RequestResult.InProgress -> RequestResult.InProgress(outData)
    }
}

internal fun <T: Any> Result<T>.toRequestResult(): RequestResult<T>{
    return when{
        isSuccess -> RequestResult.Success(getOrThrow())
        isFailure -> RequestResult.Error()
        else -> error("Impossible branch")
    }
}
