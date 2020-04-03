package com.example.qiitaappviewpager2.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager2.widget.CompositePageTransformer
import com.example.qiitaappviewpager2.R
import com.example.qiitaappviewpager2.databinding.FragmentListBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import kotlin.math.abs


class ListFragment : Fragment() {

    companion object {
        fun newInstance() = ListFragment()
    }

    private lateinit var binding: FragmentListBinding
    private lateinit var listAdapter: ListAdapter

    private val coroutineScope = CoroutineScope(context = Dispatchers.Main)

    private val viewModel by lazy {
        ViewModelProviders.of(this).get(ListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false)
        this.listAdapter = ListAdapter()

        binding.viewModel = viewModel
        binding.viewpager2.apply {
            this.adapter = listAdapter
            this.offscreenPageLimit = 2
            this.setPageTransformer(CompositePageTransformer().apply {
                val pageMarginPx = binding.root.context.resources.getDimensionPixelOffset(R.dimen.page_margin)
                val offsetPx = binding.root.context.resources.getDimensionPixelOffset(R.dimen.offset)
                addTransformer { page, position ->
                    val offset = position * (2 * offsetPx + pageMarginPx)
                    page.translationX = -offset
                }
                addTransformer { page, position ->
                    val scale = 1 - (abs(position) / 8)
                    page.scaleX = scale
                    page.scaleY = scale
                }
            })
        }
        loadData()
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        loadData()
    }


    fun loadData() {
        coroutineScope.launch {
            try {
                val getQiitaData = viewModel.getQiitaData(1, 20)
                getQiitaData.let {
                    listAdapter.setData(it)
                }
            } catch (e: HttpException) {
            }
        }
    }
}
