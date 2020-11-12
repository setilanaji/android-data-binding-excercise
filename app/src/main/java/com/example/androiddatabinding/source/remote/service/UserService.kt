package com.example.androiddatabinding

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface UserService {

    @GET("api/users")
    fun getAllUser(
        @Query("page")
        page: String
    ): Call<UserResponse>
}