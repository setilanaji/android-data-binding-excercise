package com.example.androiddatabinding.ui.activity

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import androidx.appcompat.app.AlertDialog
import com.example.androiddatabinding.R
import com.example.androiddatabinding.databinding.ActivityHomeBinding
import com.example.androiddatabinding.ui.FirstDialog

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