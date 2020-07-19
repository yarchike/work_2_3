package com.yarchike.work_2_1


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var postAdapter: PostAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initRecycleView()
        addData()

    }

    private fun initRecycleView() {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = PostAdapter()
            postAdapter = PostAdapter()
            adapter = postAdapter
        }
    }

    private fun addData() {
        val data = PostData.getDataBase()
        postAdapter.submiDataList(data)
    }


    fun ClicList(viev: View) {
        val list = postAdapter.getIteanList()
        for (i in list) {
            Log.d("MyLog", i.toString())
        }
    }


    fun clicVideo(view: View) {

    }


}






