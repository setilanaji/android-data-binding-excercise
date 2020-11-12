package com.example.androiddatabinding.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.androiddatabinding.model.PostModel
import com.example.androiddatabinding.utils.NetUtilPost
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostViewModel : BaseViewModel(){

    private val _data: MutableLiveData<List<PostModel>> by lazy {
        MutableLiveData<List<PostModel>>()
    }

    val data : LiveData<List<PostModel>>
        get() = _data

    private val _response = MutableLiveData<String>()
    val response : LiveData<String>
        get() = _response


    fun setAllPost(){
        NetUtilPost.apiService.getAllPost().enqueue(object : Callback<MutableList<PostModel>> {
            override fun onResponse(call: Call<MutableList<PostModel>>, response: Response<MutableList<PostModel>>) {
                val postResponse = response.body() as MutableList<PostModel>
                _data.postValue(postResponse)
                Log.d("TAG", "Response = $_data");
            }

            override fun onFailure(call: Call<MutableList<PostModel>>, t: Throwable) {
                Log.d("TAG", "Response = $t");
            }

        }
        )

    }

}