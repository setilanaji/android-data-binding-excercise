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


        val checkbox = CheckBox(this)
        checkbox.text = "yes"
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("Terms and Conditions")
        dialog.setIcon(R.drawable.ic_baseline_sentiment_satisfied_alt_24)
        dialog.setMessage("\n" +
                "\n" +
                "A Terms and Conditions agreement is not legally required. However, having one comes with a number of important benefits for both you and your users/customers.\n" +
                "\n" +
                "The benefits include increasing your control over your business/platform, while helping your users understand your rules, requirements and restrictions.\n")
        dialog.setView(checkbox)
        dialog.create()
        dialog.show()


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