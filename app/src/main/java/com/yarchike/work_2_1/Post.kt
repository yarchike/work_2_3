package com.yarchike.work_2_1

data class Post(
    val id: Int,
    val date: Long,
    val autor: String,
    val postResurse: String,
    var like: Int = 0,
    val comments: Int = 0,
    val share: Int = 0,
    var isLike: Boolean,
    val isComment: Boolean,
    val isShare: Boolean,
    val adress: String,
    val coordinates: Pair<Double, Double>,
    val type: PostTypes,
    val url: String? = null,
    val dateRepost: Long? = null,
    val autorRepost: String? = null,
    var hidePost: Boolean = false

) {
    override fun toString(): String {
        return "$id : $hidePost"
    }
}