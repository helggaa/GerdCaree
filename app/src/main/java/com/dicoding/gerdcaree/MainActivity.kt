package com.dicoding.gerdcaree

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var startButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startButton = findViewById(R.id.bStart)
        startButton.setOnClickListener {
            val i = Intent(this@MainActivity, LoginPage2::class.java)
            startActivity(i)
        }
    }
}