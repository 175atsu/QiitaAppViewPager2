package com.example.qiitaappviewpager2.ui

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(parent: ViewGroup?): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val data = mutableListOf<QiitaModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    }

    override fun getItemCount(): Int = data.size
}