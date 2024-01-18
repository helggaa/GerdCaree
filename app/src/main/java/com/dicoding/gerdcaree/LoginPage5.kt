package com.dicoding.gerdcaree

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class LoginPage5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page5)

        val bNext1: Button = findViewById(R.id.bNext1)
        val bLoginPage2: Button = findViewById(R.id.bLoginPage3)
        val bLoginPage3: Button = findViewById(R.id.bLoginPage4)
        val bLoginPage4: Button = findViewById(R.id.bLoginPage5)

        // Set click listeners for each button
        bNext1.setOnClickListener {
            val intent = Intent(this@LoginPage5, Login::class.java)
            startActivity(intent)
        }

        bLoginPage2.setOnClickListener {
            // Navigate to LoginPage4
            val intent = Intent(this@LoginPage5, LoginPage2::class.java)
            startActivity(intent)
        }

        bLoginPage3.setOnClickListener {
            // Navigate to LoginPage4
            val intent = Intent(this@LoginPage5, LoginPage3::class.java)
            startActivity(intent)
        }

        bLoginPage4.setOnClickListener {
            // Navigate to LoginPage5
            val intent = Intent(this@LoginPage5, LoginPage4::class.java)
            startActivity(intent)
        }
    }
}