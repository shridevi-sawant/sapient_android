package com.adobe.newsapp.model

import com.adobe.newsapp.model.NewsInterface
import com.adobe.newsapp.model.NewsResult
import javax.inject.Inject

class Repository @Inject constructor(val newsApi: NewsInterface) {

    //val newsApi = NewsInterface.getInstance()
    val apiKey = "7446209d48d143c28dff550ab5b6a2cb"

    //TODO- ROOM db handler

    suspend fun fetchTopHeadlines(ccode: String): NewsResult {
        // check network
        return newsApi.getTopHeadlines(ccode, apiKey)
    }


}