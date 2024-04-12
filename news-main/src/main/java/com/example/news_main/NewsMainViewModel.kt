package com.example.news_main

import androidx.lifecycle.ViewModel
import com.example.news.data.ArticleRepository
import com.example.news.data.RequestResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

internal class NewsMainViewModel(
  private val repository : ArticleRepository
) : ViewModel(){
  private val _state = MutableStateFlow(State.None)
  val state: StateFlow<State>
    get() = _state.asStateFlow()

  private fun RequestResult<List<Article>>.toState(): State{
    return when(this){
      is RequestResult.Error -> State.Error(data)
      is RequestResult.InProgress -> State.Loading(data)
      is RequestResult.Success -> State.Success(data)
    }
  }
}

sealed class State {
  object None : State()
  class Loading : State()
  class Error : State()
  class Success(val articles: List<Article>) : State()
}