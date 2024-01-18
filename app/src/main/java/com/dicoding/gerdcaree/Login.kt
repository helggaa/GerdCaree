package com.dicoding.gerdcaree

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.FirebaseDatabase


class Login : AppCompatActivity() {
    private lateinit var register: TextView
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var bLogin: Button
    private lateinit var database: DatabaseReference
    private lateinit var sharedPreferences: SharedPreferences

    companion object {
        const val SHARED_PREF_NAME = "myPref"
        const val KEY_USER = "user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)

        register = findViewById(R.id.tvRegister)
        register.setOnClickListener {
            val i = Intent(this@Login, Register::class.java)
            startActivity(i)
        }


        bLogin = findViewById(R.id.bLogin)

        bLogin.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()
            sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE)

            database = FirebaseDatabase.getInstance().getReference("users")

            if (username.equals("admin") && password.equals("admin")) {
                val i = Intent(this@Login, Admin::class.java)
                startActivity(i)
                Toast.makeText(applicationContext, "Login Admin", Toast.LENGTH_SHORT).show()
            }
            else if(username.isEmpty() || password.isEmpty()){
                Toast.makeText(applicationContext, "Username or Password is wrong", Toast.LENGTH_SHORT).show()
            }
            else{
                database.addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        if (snapshot.child(username).exists()) {
                            val storedPassword = snapshot.child(username).child("password").getValue(String::class.java)
                            if (storedPassword == password) {
                                Toast.makeText(applicationContext, "Login Berhasil", Toast.LENGTH_SHORT).show()

                                val masuk = Intent(applicationContext, Registration::class.java)

                                val editor = sharedPreferences.edit()
                                editor.putString(KEY_USER, username)
                                editor.apply()

                                startActivity(masuk)
                            } else {
                                Toast.makeText(applicationContext, "Data Belum Terdaftar", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        // Handle the error here
                    }
                })
            }
        }
    }
}