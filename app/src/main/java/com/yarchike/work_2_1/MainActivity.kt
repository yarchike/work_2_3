package com.yarchike.work_2_1


import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CompletableJob
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainActivity : AppCompatActivity() {

    private lateinit var postAdapter: PostAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar.visibility = ProgressBar.VISIBLE
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

        lifecycleScope.launch {
            val dataPost = PostData.getPosts()
                .filter {
                    !it.hidePost
                }
            val dataSponser = PostData.getPostSponsored()
            val data = ArrayList<Post>()


            var temp = 0
            var tempPost = 0
            for (i in 0..dataPost.size - 1) {
                data.add(dataPost[i])
                temp++
                if (temp == 3 && tempPost < dataSponser.size) {
                    temp = 0
                    data.add(dataSponser[tempPost])
                    tempPost++
                }
            }


            Log.d("MY", data.toString())
            postAdapter.submiDataList(data as ArrayList<Post>)
            postAdapter.notifyItemRangeInserted(0, data.size)
            withContext(Main) {
                progressBar.visibility = ProgressBar.GONE
            }


        }
    }


}






