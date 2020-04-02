package com.example.qiitaappviewpager2.data

import retrofit2.http.GET
import retrofit2.http.Query

interface QiitaService {
    @GET("api/v2/items")
    //多分モデルを引き出してる
    suspend fun apiDemo(
        @Query("page") page: Int,
        @Query("par_page") perPage: Int
    ): List<QiitaResponse>
}