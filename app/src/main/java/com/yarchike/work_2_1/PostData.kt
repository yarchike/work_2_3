package com.yarchike.work_2_1

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.request.get
import io.ktor.http.ContentType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class PostData {

    companion object {


        fun getDataBase(): ArrayList<Post> {

            val list = getUrl()
            return  list
        }


        fun getUrl(): ArrayList<Post> {
            var result = ArrayList<Post>()
            val client = HttpClient {
                install(JsonFeature) {
                    acceptContentTypes = listOf(
                        ContentType.Text.Plain,
                        ContentType.Application.Json
                    )
                    serializer = GsonSerializer()
                }

            }
            with(CoroutineScope(IO)) {
                launch {
                    val response: ArrayList<Post> =
                        client.get<ArrayList<Post>>(urlString = "https://raw.githubusercontent.com/yarchike/work_2_2_toJSON/master/posts.json")
                    Log.d("Myv", response.toString())
                    result = response
                    Log.d("Myv", result.toString())
                }


            }
            return result

        }


    }
}
