package com.example.androiddatabinding.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androiddatabinding.R
import com.example.androiddatabinding.databinding.ActivityPostBinding
import com.example.androiddatabinding.utils.ImageRoundedCorner
import com.squareup.picasso.Picasso

class PostActivity : AppCompatActivity() {

    lateinit var binding: ActivityPostBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val id = intent.extras?.getInt("id")
        val title = intent.extras?.getString("title")
        val body = intent.extras?.getString("body")
        binding.run {
            tvDetailPostTitle.text = title
            tvDetailPostBody.text = body
        }

    }
}