package com.dicoding.gerdcaree

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class Admin : AppCompatActivity() {
    private lateinit var bExit: Button
    private lateinit var rvUser: RecyclerView
    private lateinit var database: DatabaseReference
    private lateinit var adapter: UserAdapter
    private lateinit var arrayList: ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        bExit = findViewById(R.id.bExit)
        rvUser = findViewById(R.id.rvUser)

        bExit.setOnClickListener {
            startActivity(Intent(applicationContext, Login::class.java))
        }

        database = FirebaseDatabase.getInstance().getReferenceFromUrl("https://gerdcaree-default-rtdb.firebaseio.com/")

        rvUser = findViewById(R.id.rvUser)
        rvUser.setHasFixedSize(true)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        rvUser.layoutManager = layoutManager
        rvUser.itemAnimator = DefaultItemAnimator()

        showData()
    }

    private fun showData() {
        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                arrayList = ArrayList()

                for (item in snapshot.children) {
                    val users = User()
                    users.fullname =  item.child("fullname").getValue(String::class.java)
                    users.username = item.child("username").getValue(String::class.java)
                    users.email = item.child("email").getValue(String::class.java)
                    users.password = item.child("password").getValue(String::class.java)
                    arrayList.add(users)
                }

                adapter = UserAdapter(arrayList, this@Admin)
                rvUser.adapter = adapter
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle the error here
            }
        })
    }
}