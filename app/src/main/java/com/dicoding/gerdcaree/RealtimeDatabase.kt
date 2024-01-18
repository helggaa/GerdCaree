package com.dicoding.gerdcaree

import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

object RealtimeDatabase {
    fun instance() = Firebase.database
}