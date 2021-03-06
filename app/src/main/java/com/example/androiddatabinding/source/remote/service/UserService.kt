package com.example.androiddatabinding.source.remote.service

import com.example.androiddatabinding.source.remote.response.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface UserService {

    @GET("api/users")
    fun getAllUser(
        @Query("page")
        page: Int
    ): Call<UserResponse>
}