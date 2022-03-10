package com.hong.listview_ex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var isDouble = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list_item = mutableListOf<ListViewModel>()

        list_item.add(ListViewModel("a.", "코틀린"))
        list_item.add(ListViewModel("c.", "자바"))
        list_item.add(ListViewModel("e.", "파이썬"))

        val listView = findViewById<ListView>(R.id.mainListView)
        val listAdapter = ListViewAdapter(list_item)

        listView.adapter = listAdapter

    }

    override fun onBackPressed() {
        Log.d("MainActivity", "backButton")
        if (isDouble) {
            finish()
        }
        isDouble = true
        Toast.makeText(this, "종료하실려면 더블 클릭", Toast.LENGTH_SHORT).show()

        Handler().postDelayed(Runnable {
            isDouble = false
        }, 2000)


    }

}