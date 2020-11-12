package com.example.androiddatabinding.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.androiddatabinding.source.remote.response.UserResponse
import com.example.androiddatabinding.model.UserModel
import com.example.androiddatabinding.utils.NetUtilUser
import retrofit2.Call
import retrofit2.Response


class UserViewModel : BaseViewModel() {
    private val _data: MutableLiveData<List<UserModel>> by lazy {
        MutableLiveData<List<UserModel>>()
    }

    val data : LiveData<List<UserModel>>
        get() = _data

    private val _response = MutableLiveData<String>()
    val response : LiveData<String>
        get() = _response


    fun setAllUser(){
        NetUtilUser.apiService.getAllUser("1").enqueue(object :
                retrofit2.Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                val userResponse = response.body()
                _data.postValue(userResponse?.result)
                Log.d("TAG", "Response = $_data");
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                Log.d("TAG", "Response = $t");
            }

        }

        )

    }


}