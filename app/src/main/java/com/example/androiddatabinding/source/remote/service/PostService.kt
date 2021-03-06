package com.example.androiddatabinding.source.remote.service

import com.example.androiddatabinding.model.PostModel
import retrofit2.Call
import retrofit2.http.GET

interface PostService {

    @GET("posts")
    fun getAllPost(): Call<MutableList<PostModel>>
}