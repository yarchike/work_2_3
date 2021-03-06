package com.yarchike.work_2_1

import io.ktor.client.HttpClient
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.http.ContentType
import io.ktor.http.contentType


object PostData {

    private val client = HttpClient {
        install(JsonFeature) {
            serializer = GsonSerializer()
            accept(ContentType.Text.Plain, ContentType.Application.Json)
        }
    }

    suspend fun getPosts(): List<Post> {
        var list = ArrayList<Post>()

        list = client.get("https://server-martynov.herokuapp.com/api/v1/posts")

        return list
    }


    suspend fun getPostSponsored(): List<Post> =
        client.get(urlString = "https://raw.githubusercontent.com/yarchike/work_2_2_toJSON/master/posts_sponser.json")

    suspend fun postPosts(post: Post): Post =
        client.post("https://server-martynov.herokuapp.com/api/v1/posts") {
            body = post
            contentType(ContentType.Application.Json)
        }
}




