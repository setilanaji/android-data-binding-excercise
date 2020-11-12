package com.example.androiddatabinding.ui.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.androiddatabinding.R


class Session(private val context: Context){
    companion object{
        const val SHARED = "ydh"

        const val FIRST_TIME = "FIRST_TIME_KEY"
    }

//    private val pref: SharedPreferences by lazy {
//        context.getSharedPreferences(SHARED, "")
//    }

    private fun isFirstTIme(): Boolean{

    }
}

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }, 3000)
    }
}