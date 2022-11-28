package com.example.onboardingscereen.network

import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient {



    private var retrofit: Retrofit? = null

    fun getClient(): ServicesBuilder {

//        val interceptor =  HttpLoggingInterceptor()
//        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
//
//        val client =  OkHttpClient.Builder().addInterceptor(interceptor).build()
    val gson = GsonBuilder()
        .setLenient()
        .create()


        var httpClient =OkHttpClient()
        httpClient.networkInterceptors.add(Interceptor { chain ->
            val requestBuilder: Request.Builder = chain.request().newBuilder()
            requestBuilder?.header("Content-Type", "application/json")
            requestBuilder?.build()?.let { chain.proceed(it) }!!
        });

        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl("https://restaurants.alexon.live/api/")
               .client(httpClient)
                .build()

        }


        return retrofit!!.create(ServicesBuilder::class.java)
    }




}

private fun <E> List<E>.add(e: E) {

}


