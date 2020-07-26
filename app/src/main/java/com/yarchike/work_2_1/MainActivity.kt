package com.yarchike.work_2_1


import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.postv_view.*
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.ConnectException


class MainActivity : AppCompatActivity() {

    private val postAdapter: PostAdapter = PostAdapter() { post ->

        lifecycleScope.launch {
            try {
                val postTemp = PostData.postPosts(post)

            } catch (e: ConnectException) {
                withContext(Main) {
                    Toast.makeText(
                        this@MainActivity,
                        "Ошибка с соединенеие с сервером",
                        Toast.LENGTH_LONG
                    ).show()
                }
                /*if (post.isLike) {
                    post.isLike = false
                    post.like--
                    likeImage.setImageResource(R.drawable.ic_no_like)
                    likeText.setTextColor(Color.BLACK)
                    likeText.text = post.like.toString()
                } else {
                    post.isLike = true
                    post.like++
                    likeImage.setImageResource(R.drawable.ic_like)
                    likeText.setTextColor(Color.RED)
                    likeText.text = post.like.toString()
                }*/
            }
        }
    }


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
            adapter = postAdapter
        }
    }


    private fun addData() {

        lifecycleScope.launch {
            try {
                val dataPost = PostData.getPosts()
                    .filter {
                        !it.hidePost
                    }
                val dataSponser = PostData.getPostSponsored()
                val data = ArrayList<Post>()


                var temp = 0
                var tempPost = 0
                for (element in dataPost) {
                    data.add(element)
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

            } catch (e: ConnectException) {
                Toast.makeText(
                    this@MainActivity,
                    "Ошибка с соединенеие с сервером",
                    Toast.LENGTH_LONG
                ).show()
            }

        }
    }


}






