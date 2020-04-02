package com.example.qiitaappviewpager2.data

class QiitaRepository (private val qiitaService: QiitaService) {
    suspend fun getQiitaData(page: Int, perPage: Int): List<QiitaResponse> {
        return qiitaService.apiDemo(page, perPage)
    }
}
