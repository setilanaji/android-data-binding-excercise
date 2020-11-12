package com.example.androiddatabinding.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.androiddatabinding.ui.adapter.PostAdapter
import com.example.androiddatabinding.databinding.ActivityThirdBinding
import com.example.androiddatabinding.model.PostModel
import com.example.androiddatabinding.model.UserModel
import com.example.androiddatabinding.ui.adapter.UserAdapter
import com.example.androiddatabinding.utils.NetUtilPost
import com.example.androiddatabinding.viewmodel.PostViewModel
import com.example.androiddatabinding.viewmodel.UserViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ThirdActivity : AppCompatActivity() {

    lateinit var binding: ActivityThirdBinding

//    private var listPost: MutableList<PostModel> = mutableListOf()
//    private var adapter: PostAdapter? = null

    private lateinit var postViewModel: PostViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        listPost = mutableListOf()
//
//        val staggeredGridLayoutManager: StaggeredGridLayoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
//        binding.recyclerThirdPost.layoutManager = staggeredGridLayoutManager
//        adapter = PostAdapter(this, listPost)
//        binding.recyclerThirdPost.adapter = adapter
//        getPostData()
        setViewModel()
        setData()
    }
    private fun setViewModel(){
        postViewModel = ViewModelProviders.of(this).get(PostViewModel::class.java)
    }

    private fun setData(){
        postViewModel.setAllPost()

        postViewModel.data.observe({ lifecycle }, {
            val postAdapter = PostAdapter(this, it as MutableList<PostModel>,
                object :   PostAdapter.PostItemListener {
                override fun onPostClick(postModel: PostModel) {
                    val intent = Intent(this@ThirdActivity, PostActivity::class.java)
                    intent.putExtra("id", postModel.id)
                    intent.putExtra("title", postModel.title)
                    intent.putExtra("title", postModel.body)
                    startActivity(intent)
                }

            })
            val recyclerView = binding.recyclerThirdPost

            recyclerView.apply {
                this.adapter = postAdapter
                this.layoutManager =
                        StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
            }
        })

        postViewModel.response.observe({ lifecycle }, {
            if (it.isNotEmpty()) {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        })
    }
}