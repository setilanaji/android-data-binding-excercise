package com.example.androiddatabinding.ui.activity

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androiddatabinding.R
import com.example.androiddatabinding.databinding.ActivityUserBinding
import com.example.androiddatabinding.utils.ImageRoundedCorner
import com.squareup.picasso.Picasso

class UserActivity : AppCompatActivity() {

    lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent.extras?.getInt("id")
        val fname = intent.extras?.getString("firstName")
        val lname = intent.extras?.getString("lastName")
        val email = intent.extras?.getString("email")
        val imgUrl = intent.extras?.getString("url")

        print(fname)

        binding.run {
            tvDetailUserName.text = fname + " " + lname
            tvDetailUserEmail.text = email
            Picasso.get().load(imgUrl).transform(ImageRoundedCorner()).into(this.imageView)
        }

    }
}