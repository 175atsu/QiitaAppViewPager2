package com.example.qiitaappviewpager2.data

data class QiitResponse(
    val url: String?,
    val title: String?,
    val user: User?
)

data class User(
    val id: String?,
    val profile_image_url: String
)