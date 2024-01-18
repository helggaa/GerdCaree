package com.dicoding.gerdcaree

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.dicoding.gerdcaree.R


class LoginPage3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page3)
        // Find your buttons by their IDs
        val bNext: ImageButton = findViewById(R.id.bNext)
        val bLoginPage2: Button = findViewById(R.id.bLoginPage3)
        val bLoginPage4: Button = findViewById(R.id.bLoginPage4)
        val bLoginPage5: Button = findViewById(R.id.bLoginPage5)

        // Set click listeners for each button
        bNext.setOnClickListener {
            // Navigate to LoginPage3
            val intent = Intent(this@LoginPage3, LoginPage4::class.java)
            startActivity(intent)
        }

        bLoginPage2.setOnClickListener {
            // Navigate to LoginPage4
            val intent = Intent(this@LoginPage3, LoginPage2::class.java)
            startActivity(intent)
        }

        bLoginPage4.setOnClickListener {
            // Navigate to LoginPage4
            val intent = Intent(this@LoginPage3, LoginPage4::class.java)
            startActivity(intent)
        }

        bLoginPage5.setOnClickListener {
            // Navigate to LoginPage5
            val intent = Intent(this@LoginPage3, LoginPage5::class.java)
            startActivity(intent)
        }
    }
}


//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_login_page3)
//
//        buttonNextPage = findViewById(R.id.bNext)
//        buttonNextPage.setOnClickListener {
//            val i = Intent(this@LoginPage3, LoginPage4::class.java)
//            startActivity(i)
//        }
//
//        buttonPage2 = findViewById(R.id.bLoginPage2)
//        buttonPage2.setOnClickListener{
//            val i = Intent(this@LoginPage3, LoginPage2::class.java)
//            startActivity(i)
//        }
//
//        buttonPage4 = findViewById(R.id.bLoginPage4)
//        buttonPage4.setOnClickListener{
//            val i = Intent(this@LoginPage3, LoginPage4::class.java)
//            startActivity(i)
//        }
//
//        buttonPage5 = findViewById(R.id.bLoginPage5)
//        buttonPage5.setOnClickListener{
//            val i = Intent(this@LoginPage3, LoginPage5::class.java)
//            startActivity(i)
//        }
//    }
