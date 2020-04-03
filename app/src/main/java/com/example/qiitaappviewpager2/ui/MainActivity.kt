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
}
