package com.example.androiddatabinding.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.androiddatabinding.*
import com.example.androiddatabinding.adapter.PostAdapter
import com.example.androiddatabinding.adapter.UserAdapter
import com.example.androiddatabinding.databinding.ActivityThirdBinding
import com.example.androiddatabinding.model.PostModel
import com.example.androiddatabinding.model.UserModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ThirdActivity : AppCompatActivity() {

    lateinit var binding: ActivityThirdBinding

    private var listPost: MutableList<PostModel> = mutableListOf()
    private var adapter: PostAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listPost = mutableListOf()

        val staggeredGridLayoutManager: StaggeredGridLayoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        binding.recyclerThirdPost.layoutManager = staggeredGridLayoutManager
        adapter = PostAdapter(this, listPost)
        binding.recyclerThirdPost.adapter = adapter
        getPostData()
    }

    private fun getPostData(){
        NetUtilPost.apiService.getAllPost().enqueue(object : Callback<MutableList<PostModel>> {
            override fun onResponse(call: Call<MutableList<PostModel>>, response: Response<MutableList<PostModel>>) {
                val postResponse = response.body() as MutableList<PostModel>
                println(postResponse)
                listPost.clear()
                postResponse.let {
                            it.forEach { x -> println(x.toString()) }
                    listPost.addAll(it)
                }
                adapter?.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<MutableList<PostModel>>, t: Throwable) {
                Log.d("TAG", "Response = $t");
            }

        }
        )
    }
}