package com.example.androiddatabinding.source.remote.response

import com.example.androiddatabinding.model.PostModel
import com.example.androiddatabinding.model.UserModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PostResponse(
        @Expose
        val result: List<PostModel>
)