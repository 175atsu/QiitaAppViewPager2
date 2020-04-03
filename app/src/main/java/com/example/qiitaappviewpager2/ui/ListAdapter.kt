package com.example.qiitaappviewpager2.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.qiitaappviewpager2.R
import com.example.qiitaappviewpager2.data.QiitaResponse

class ListAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val data = mutableListOf<QiitaResponse>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ListViewHolder(DataBindingUtil.inflate(layoutInflater, R.layout.view_list_cell, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ListViewHolder).apply {
            bind(data[position])
        }
    }

    override fun getItemCount(): Int = data.size

    fun setData(i: List<QiitaResponse>) {
        data.clear()
        data.addAll(i)
        notifyDataSetChanged()
    }
}