package com.example.marsapp

import com.example.marsapp.api.MarsProperty
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

//Add the following constant for the base URL for the web service.
private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com"

/*
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()
*/

//add a Retrofit builder to build and create a Retrofit object. Add Moshi Converter Factory to Retrofit
private val retrofit = Retrofit.Builder()
    //.client(moshi)
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface MarsApiServices {
    @GET("realestate")
    fun getProperties(): Call<List<MarsProperty>>
}

object MarsApi {
    val retrofitService : MarsApiServices by lazy {
        retrofit.create(MarsApiServices::class.java)
    }
}

/*
  val  okHttpClient = OkHttpClient.Builder().addInterceptor(networkConnectionInterceptor).build()

// using moshi. moshi is a modern json library for android.

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

//add a Retrofit builder to build and create a Retrofit object. Add Moshi Converter Factory to Retrofit
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()
*/
