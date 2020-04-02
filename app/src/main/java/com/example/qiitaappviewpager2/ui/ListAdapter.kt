package com.example.qiitaappviewpager2.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.qiitaappviewpager2.data.QiitaResponse

class ListAdapter(parent: ViewGroup?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val data = mutableListOf<QiitaResponse>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ListViewHolder()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    }

    override fun getItemCount(): Int = data.size
}