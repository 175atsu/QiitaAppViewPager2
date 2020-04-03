package com.example.qiitaappviewpager2.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.qiitaappviewpager2.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.add(R.id.listFragment, ListFragment.newInstance())
            transaction.commit()
        }
    }

//    private lateinit var binding: ActivityMainBinding
//    private lateinit var listFragment: ListFragment
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        this.binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        initView()
//    }
//
//    private fun initView() {
//        val context = applicationContext
//        val manager = supportFragmentManager
//        val transaction = manager.beginTransaction()
//        this.listFragment = ListFragment.newInstance()
//        transaction.addToBackStack(null)
//        transaction.add(R.id.listFragment, listFragment)
//        transaction.commit()
//    }
}
