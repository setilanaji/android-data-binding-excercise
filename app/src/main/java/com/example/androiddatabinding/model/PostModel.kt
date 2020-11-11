package com.example.androiddatabinding.model

import com.google.gson.annotations.SerializedName
import retrofit2.http.Body

data class PostModel(
    @SerializedName("userId")
    val userId: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("body")
    val body: String
)