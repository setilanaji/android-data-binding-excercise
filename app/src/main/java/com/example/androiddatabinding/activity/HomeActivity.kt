package com.example.androiddatabinding.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.androiddatabinding.R
import com.example.androiddatabinding.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.run {
            buttonOne.setOnClickListener(this@HomeActivity)
            buttonTwo.setOnClickListener(this@HomeActivity)
        }

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.button_one -> startActivity(Intent(this, SecondActivity::class.java))
            R.id.button_two -> startActivity(Intent(this, ThirdActivity::class.java))
        }
    }


}