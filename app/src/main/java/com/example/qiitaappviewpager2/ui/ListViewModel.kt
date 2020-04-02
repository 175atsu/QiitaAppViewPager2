package com.example.qiitaappviewpager2.ui

import androidx.lifecycle.ViewModel
import com.example.qiitaappviewpager2.data.QiitaRepository
import com.example.qiitaappviewpager2.data.QiitaResponse

class ListViewModel (private val qiitaRepository: QiitaRepository): ViewModel() {
    suspend fun getQiitaData(page: Int, perPage: Int): List<QiitaResponse> {
        return qiitaRepository.getQiitaData(page, perPage)
    }
}