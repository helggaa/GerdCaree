package com.dicoding.gerdcaree

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class LoginPage2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page2)

        // Find your buttons by their IDs
        val bNext: ImageButton = findViewById(R.id.bNext)
        val bLoginPage3: Button = findViewById(R.id.bLoginPage3)
        val bLoginPage4: Button = findViewById(R.id.bLoginPage4)
        val bLoginPage5: Button = findViewById(R.id.bLoginPage5)

        // Set click listeners for each button
        bNext.setOnClickListener {
            // Navigate to LoginPage3
            val intent = Intent(this@LoginPage2, LoginPage3::class.java)
            startActivity(intent)
        }

        bLoginPage3.setOnClickListener {
            // Navigate to LoginPage4
            val intent = Intent(this@LoginPage2, LoginPage4::class.java)
            startActivity(intent)
        }

        bLoginPage4.setOnClickListener {
            // Navigate to LoginPage4
            val intent = Intent(this@LoginPage2, LoginPage4::class.java)
            startActivity(intent)
        }

        bLoginPage5.setOnClickListener {
            // Navigate to LoginPage5
            val intent = Intent(this@LoginPage2, LoginPage5::class.java)
            startActivity(intent)
        }
    }
}


//        buttonNextPage = findViewById(R.id.bNext)

//        buttonNextPage.setOnClickListener {
//            val i = Intent(this@LoginPage2, LoginPage3::class.java)
//            startActivity(i)
//        }

//        buttonPage3 = findViewById(R.id.bLoginPage3)
//        buttonPage3.setOnClickListener {
//            val i = Intent(this@LoginPage2, LoginPage4::class.java) // Change to the desired destination
//            startActivity(i)
//        }

//        buttonPage4 = findViewById(R.id.bLoginPage4)
//        buttonPage4.setOnClickListener {
//            val i = Intent(this@LoginPage2, LoginPage4::class.java)
//            startActivity(i)
//        }
//
//        buttonPage5 = findViewById(R.id.bLoginPage5)
//        buttonPage5.setOnClickListener {
//            val i = Intent(this@LoginPage2, LoginPage5::class.java)
//            startActivity(i)
//        }


