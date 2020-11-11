package com.example.androiddatabinding

import androidx.annotation.Nullable
import com.example.androiddatabinding.model.UserModel
import com.google.gson.annotations.SerializedName

data class UserResponse (
    @SerializedName("page")
    val page: Int,
    @SerializedName("per_page")
    val perPage: Int,
    @SerializedName("total")
    val total: Int,
    @SerializedName("total_pages")
    val totalPages: Int,
    @Nullable
    val result: List<UserModel>

)