package com.yarchike.work_2_1

import io.ktor.client.HttpClient
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.request.get
import io.ktor.http.ContentType


object PostData {
    private val client = HttpClient {
        install(JsonFeature) {
            serializer = GsonSerializer()
            accept(ContentType.Text.Plain, ContentType.Application.Json)
        }
    }

    suspend fun getPosts(): List<Post> =
        client.get(urlString = "https://raw.githubusercontent.com/yarchike/work_2_2_toJSON/master/posts.json")
    suspend fun getPostSponsored( ): List<Post> =
        client.get(urlString = "https://raw.githubusercontent.com/yarchike/work_2_2_toJSON/master/posts_sponser.json")
}



