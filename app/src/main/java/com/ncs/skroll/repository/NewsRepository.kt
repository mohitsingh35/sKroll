package com.ncs.skroll.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ncs.skroll.models.NewsData
import com.ncs.skroll.retofit.NewsApi
import javax.inject.Inject

class NewsRepository @Inject constructor(private val newsApi: NewsApi) {

    private val newsLiveData= MutableLiveData<NewsData>()
    val news: LiveData<NewsData>
        get() = newsLiveData


    suspend fun getNews(apiKey:String){

        val result=newsApi.getNews(apiKey)
        if(result.isSuccessful && result.body() != null) {
            newsLiveData.postValue(result.body()!!)
        }
    }


}