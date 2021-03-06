package com.example.qiitaappviewpager2.data

import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class QiitaRepository () {

    private var retrofit: Retrofit
    private val url = "https://qiita.com"

    init {
        //Moshi
        val moshi: Moshi = Moshi.Builder()
            .build()

        //クライアント生成
        this.retrofit = Retrofit.Builder()
            .baseUrl(url)//基本のurl設定
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(getClient())//カスタマイズしたokhttpのクライアントの設定
            .build()
    }

    private fun getClient(): OkHttpClient {
        return OkHttpClient
            .Builder()
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }

    fun getQiitaData(): QiitaService {
        return retrofit.create(QiitaService::class.java)
    }
}
