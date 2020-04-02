package com.example.qiitaappviewpager2.ui

import androidx.recyclerview.widget.RecyclerView
import com.example.qiitaappviewpager2.data.QiitaResponse
import com.example.qiitaappviewpager2.databinding.ViewListCellBinding

class ListViewHolder (private val binding: ViewListCellBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(qiitaResponse: QiitaResponse) {
        this.commonBind(qiitaResponse)
    }
    fun commonBind(qiitaResponse: QiitaResponse) {
        binding.webView.loadUrl(qiitaResponse.url)
    }
}