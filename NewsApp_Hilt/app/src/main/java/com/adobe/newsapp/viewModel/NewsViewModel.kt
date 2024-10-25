package com.adobe.newsapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adobe.newsapp.model.News
import com.adobe.newsapp.model.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

// no reference to view (activity/frag)
// data required by view is exposed
// make use of viewModelScope

@HiltViewModel
class NewsViewModel @Inject constructor(private val repo: Repository):
    ViewModel() {

    //private val repo = Repository()

    val newsList = MutableLiveData<List<News>>()

    fun fetchNews(country: String){
        viewModelScope.launch(Dispatchers.Default) {
            val result = repo.fetchTopHeadlines(country)
            //delay(2000)
            newsList.postValue(result.articles)
        }
    }

}