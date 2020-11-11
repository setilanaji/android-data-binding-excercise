package com.example.androiddatabinding.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androiddatabinding.utils.NetUtilUser
import com.example.androiddatabinding.UserResponse
import com.example.androiddatabinding.ui.adapter.UserAdapter
import com.example.androiddatabinding.databinding.ActivitySecondBinding
import com.example.androiddatabinding.model.UserModel
import com.example.androiddatabinding.viewmodel.UserViewModel
import retrofit2.Call
import retrofit2.Response

class SecondActivity : AppCompatActivity() {

    lateinit var binding: ActivitySecondBinding

    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setViewModel()
        setData()

    }

    private fun setViewModel(){
        userViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
    }

    private fun setData(){
        userViewModel.setAllUser()

        userViewModel.data.observe({ lifecycle }, {
            val userAdapter = UserAdapter(this, it as MutableList<UserModel>)
            val recyclerView = binding.recyclerMainUser

            recyclerView.apply {
                this.adapter = userAdapter
                this.layoutManager =
                        LinearLayoutManager(this@SecondActivity)
            }
        })

        userViewModel.response.observe({ lifecycle }, {
            if (it.isNotEmpty()) {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        })
    }

}