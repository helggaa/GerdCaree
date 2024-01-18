package com.dicoding.gerdcaree

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase

class EditDataUser : AppCompatActivity() {
    private lateinit var etFullname: EditText
    private lateinit var etEmail: EditText
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var bSave: Button
    private lateinit var bCancel: Button

    private var fullname: String? = null
    private var email: String? = null
    private var username: String? = null
    private var password: String? = null

    private var database = FirebaseDatabase.getInstance().getReferenceFromUrl("https://gerdcaree-default-rtdb.firebaseio.com/");

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_data_user)

        etFullname = findViewById(R.id.etFullname)
        etEmail = findViewById(R.id.etEmail)
        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        bSave = findViewById(R.id.bSave)
        bCancel = findViewById(R.id.bCancel)

        if (intent.hasExtra("fullname") && intent.hasExtra("email") && intent.hasExtra("username") && intent.hasExtra("password")) {
            fullname = intent.getStringExtra("fullname")
            email = intent.getStringExtra("email")
            username = intent.getStringExtra("username")
            password = intent.getStringExtra("password")
        }

        etFullname.setText(fullname)
        etEmail.setText(email)
        etUsername.setText(username)
        etPassword.setText(password)

        bCancel.setOnClickListener {
            startActivity(Intent(applicationContext, Admin::class.java))
        }

        bSave.setOnClickListener {
            val newFullname = etFullname.text.toString()
            val newEmail = etEmail.text.toString()
            val newPassword = etPassword.text.toString()

            val hashMap = HashMap<String, Any>()
            hashMap["fullname"] = newFullname
            hashMap["email"] = newEmail
            hashMap["password"] = newPassword

            database.child(username.toString()).updateChildren(hashMap).addOnSuccessListener {
                Toast.makeText(applicationContext, "Update Berhasil", Toast.LENGTH_SHORT).show()
                startActivity(Intent(applicationContext, Admin::class.java))
            }
        }
    }
}