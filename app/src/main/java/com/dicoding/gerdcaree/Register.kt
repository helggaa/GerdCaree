package com.dicoding.gerdcaree

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Register : AppCompatActivity() {
    private lateinit var etFullName: EditText
    private lateinit var etEmail: EditText
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var bSubmit: Button

    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        etFullName = findViewById(R.id.etFullname)
        etEmail = findViewById(R.id.etEmail)
        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        bSubmit = findViewById(R.id.bSubmit)

        database = FirebaseDatabase.getInstance().getReferenceFromUrl("https://gerdcaree-default-rtdb.firebaseio.com/");

        bSubmit.setOnClickListener(View.OnClickListener {
            val fullname = etFullName.text.toString()
            val email = etEmail.text.toString()
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(applicationContext, "Ada Data Yang Masih Kosong!!", Toast.LENGTH_SHORT).show()
            } else {
                val userReference = database.child("users")
                userReference.child(username).child("username").setValue(username)
                userReference.child(username).child("fullname").setValue(fullname)
                userReference.child(username).child("email").setValue(email)
                userReference.child(username).child("password").setValue(password)

                Toast.makeText(applicationContext, "Register Berhasil", Toast.LENGTH_SHORT).show()
                val registerIntent = Intent(this@Register, Login::class.java)
                startActivity(registerIntent)
            }
        })
    }
}