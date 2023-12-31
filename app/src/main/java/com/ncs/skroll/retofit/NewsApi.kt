package com.ncs.skroll.retofit

import com.ncs.skroll.models.NewsData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("v2/top-headlines?country=in")
    suspend fun getNews(@Query("apiKey") apiKey:String) : Response<NewsData>
}