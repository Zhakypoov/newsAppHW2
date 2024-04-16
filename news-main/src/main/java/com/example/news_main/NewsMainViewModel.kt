package com.example.news_main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news.data.ArticleRepository
import com.example.news.data.RequestResult
import com.example.news.data.map
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject
import javax.inject.Provider


@HiltViewModel
internal class NewsMainViewModel @Inject constructor(
    getArticleUseCase: Provider<GetArticleUseCase>,
//    private val repository: ArticleRepository
) : ViewModel() {
   val state: StateFlow<State> = getArticleUseCase.get().invoke()
    .map { it.toState() }
    .stateIn(viewModelScope, SharingStarted.Lazily, State.None)


//    fun forceUpdate(){
//        val requestResultFlow = repository.fetchLatest()
//    }
}






private fun RequestResult<List<Article>>.toState(): State{
  return when(this){
    is RequestResult.Error -> State.Error()
    is RequestResult.InProgress -> State.Loading(data)
    is RequestResult.Success -> State.Success(checkNotNull(data))
  }
}



sealed class State {
  object None : State()
  class Loading(val articles: List<Article>? = null) : State()
  class Error(val articles: List<Article>? = null) : State()
  class Success(val articles: List<Article>) : State()
}