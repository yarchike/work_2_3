package com.yarchike.work_2_1

data class PostRequestDto(
    val id: Long,
    val autor: String? = null,
    val postResurse: String? = null,
    var like: Int = 0,
    var isLike: Boolean = false
)
