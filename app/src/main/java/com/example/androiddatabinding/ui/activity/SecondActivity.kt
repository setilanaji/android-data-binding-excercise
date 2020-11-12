package com.example.androiddatabinding.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androiddatabinding.ui.adapter.UserAdapter
import com.example.androiddatabinding.databinding.ActivitySecondBinding
import com.example.androiddatabinding.model.UserModel
import com.example.androiddatabinding.viewmodel.UserViewModel

class SecondActivity : AppCompatActivity() {

    lateinit var binding: ActivitySecondBinding

    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.editTextTextPersonName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })
        setViewModel()
        setData()

    }

    private fun setViewModel(){
        userViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
    }

    private fun setData(){
        userViewModel.setAllUser()

        userViewModel.data.observe({ lifecycle }, {
            val userAdapter = UserAdapter(this, it as MutableList<UserModel>,
                object :   UserAdapter.PostItemListener {
                    override fun onPostClick(userModel: UserModel) {
                        val intent = Intent(this@SecondActivity, UserActivity::class.java)
                        intent.putExtra("id", userModel.id)
                        intent.putExtra("firstName", userModel.firstName)
                        intent.putExtra("lastName", userModel.lastName)
                        intent.putExtra("email", userModel.email)
                        intent.putExtra("url", userModel.avatarImgUrl)
                        startActivity(intent)
                    }

                })
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