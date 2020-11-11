package com.example.androiddatabinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androiddatabinding.databinding.ActivityMainBinding
import com.example.androiddatabinding.model.UserModel
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private var listUser: MutableList<UserModel> = mutableListOf()
    private var adapter: UserAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listUser = mutableListOf()

        binding.recyclerMainUser.layoutManager = LinearLayoutManager(this)
        adapter = UserAdapter(this, listUser)
        binding.recyclerMainUser.adapter = adapter
        getUserData()

    }

    private fun getUserData(){
        NetUtil.apiService.getAllUser("1").enqueue(object :
            retrofit2.Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
               val userResponse = response.body()
                listUser.clear()
                userResponse?.let {
                    it.result.forEach { x -> println(x.toString()) }
                    listUser.addAll(it.result)
                }
                Log.d("TAG", "Response = $listUser");
                adapter?.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                Log.d("TAG", "Response = $t");
            }

        }

        )
    }
}