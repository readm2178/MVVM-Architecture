package com.rajkumarrajan.mvvm_architecture.ui.main.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rajkumarrajan.mvvm_architecture.R
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        button1.setOnClickListener {
            val intent =Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        button2.setOnClickListener {
            val intent1 =Intent(this,MainActivity2::class.java)
            startActivity(intent1)
        }
    }
}