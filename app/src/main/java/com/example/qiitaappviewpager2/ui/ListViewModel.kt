package com.example.qiitaappviewpager2.ui

import androidx.lifecycle.ViewModel
import com.example.qiitaappviewpager2.data.QiitaRepository
import com.example.qiitaappviewpager2.data.QiitaResponse

class ListViewModel () : ViewModel() {

    val qiitaRepository = QiitaRepository()

    suspend fun getQiitaData(page: Int, perPage: Int): List<QiitaResponse> {
        return qiitaRepository.getQiitaData().apiDemo(page, perPage)
    }
}