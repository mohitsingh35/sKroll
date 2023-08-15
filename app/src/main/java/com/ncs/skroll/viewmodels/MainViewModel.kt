package com.ncs.skroll.viewmodels


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ncs.skroll.models.NewsData
import com.ncs.skroll.repository.NewsRepository
import com.ncs.skroll.utils.constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: NewsRepository) : ViewModel() {


    val newsLiveData : LiveData<NewsData>
        get() = repository.news
    var items: NewsData?=null
    init {
        val apiKey=constants.API_KEY
        viewModelScope.launch{
            repository.getNews(apiKey)
        }
        returnNews()
    }
    fun returnNews(){
        newsLiveData.observeForever { news->
            items=news
        }

    }
}