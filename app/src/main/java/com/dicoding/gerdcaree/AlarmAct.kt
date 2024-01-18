package com.dicoding.gerdcaree

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton


class AlarmAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm)

        lateinit var imageButton: ImageButton

        imageButton = findViewById(R.id.edit1) as ImageButton

        imageButton.setOnClickListener {
            onEditAlarmButtonClick()
        }
    }

    private fun onEditAlarmButtonClick() {
        val intent = Intent(this, AddAlarmAct::class.java)
        startActivity(intent)
    }
}