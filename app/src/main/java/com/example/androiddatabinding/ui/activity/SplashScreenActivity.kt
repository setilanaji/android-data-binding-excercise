package com.example.androiddatabinding.ui.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.CheckBox
import androidx.appcompat.app.AlertDialog
import androidx.core.content.edit
import com.example.androiddatabinding.R
import com.example.androiddatabinding.databinding.ActivitySplashScreenBinding
import com.example.androiddatabinding.databinding.DialogFirstBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder


class Session(private val context: Context){
    companion object{
        const val SHARED = "ydh"

        const val FIRST_TIME = "FIRST_TIME_KEY"
    }

    private val pref: SharedPreferences by lazy {
        context.getSharedPreferences(SHARED, Context.MODE_PRIVATE)
    }

    fun isFirstTIme(): Boolean{
        return pref.getBoolean(FIRST_TIME, true)
    }

    fun setFirstTime(value: Boolean){
        pref.edit { putBoolean(FIRST_TIME, value) }
    }
}

class SplashScreenActivity : AppCompatActivity() {

    private val session by lazy { Session(this) }
    lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler(Looper.getMainLooper()).postDelayed({
//            if (session.isFirstTIme()){
//                showDialog()
//            }else{
                startActivity(Intent(this, HomeActivity::class.java))
                session.setFirstTime(false)
                finish()
//            }


        }, 3000)
    }

    private fun showDialog(){
        MaterialAlertDialogBuilder(this).run {
            setFinishOnTouchOutside(false)
            DialogFirstBinding.inflate(layoutInflater)


            show()
        }
//        val checkbox = CheckBox(this)
//        checkbox.text = "yes"
//        val dialog = AlertDialog.Builder(this)
//        dialog.setTitle("Terms and Conditions")
//        dialog.setIcon(R.drawable.ic_baseline_sentiment_satisfied_alt_24)
//        dialog.setMessage("\n" +
//                "\n" +
//                "A Terms and Conditions agreement is not legally required. However, having one comes with a number of important benefits for both you and your users/customers.\n" +
//                "\n" +
//                "The benefits include increasing your control over your business/platform, while helping your users understand your rules, requirements and restrictions.\n")
//        dialog.setView(checkbox)
//        dialog.create()
//        dialog.show()
    }
}