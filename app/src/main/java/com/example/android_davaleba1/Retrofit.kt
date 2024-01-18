package com.example.android_davaleba1

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

object Retrofit {

    private const val BASE_URL = "https://run.mocky.io/v3/"

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api = retrofit.create(Service::class.java)

}

interface Service {
    @GET("01532b41-82a2-4183-aa2e-71bc7e70aa29")
    suspend fun getItems(): Response<List<Items.ItemModel>>
}