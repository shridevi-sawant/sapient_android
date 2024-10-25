package com.adobe.newsapp.di



import com.adobe.newsapp.model.NewsInterface
import com.adobe.newsapp.model.Repository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesRetrofit(gson: Gson): Retrofit {
        return Retrofit.Builder()
                .baseUrl("https://newsapi.org/v2/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
    }

    @Singleton
    @Provides
    fun providesGson(): Gson = GsonBuilder().create()

    @Singleton
    @Provides
    fun providesNewsApi(retrofit: Retrofit): NewsInterface {
        return retrofit.create(NewsInterface::class.java)
    }

//    @Singleton
//    @Provides
//    fun providesRepo(newsApi: NewsInterface): Repository {
//        return Repository(newsApi)
//    }
}