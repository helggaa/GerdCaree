package com.dicoding.gerdcaree

import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import android.widget.TimePicker
import java.util.Calendar

class AddAlarmAct : AppCompatActivity(), TimePickerDialog.OnTimeSetListener {
    var jam = 0
    var menit = 0
    lateinit var teksWaktu: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_alarm)
        lateinit var imageButton: ImageButton

        imageButton = findViewById(R.id.editsong) as ImageButton

        imageButton.setOnClickListener {
            onEditSongButtonClick()
        }
    }

    private fun onEditSongButtonClick() {
        val intent = Intent(this, AddSong::class.java)
        startActivity(intent)
    }


    fun getSaatIni(){
        val kal: Calendar = Calendar.getInstance()
        jam = kal.get(Calendar.HOUR_OF_DAY)
        menit = kal.get(Calendar.MINUTE)
    }

    fun fSetWaktu(view: View){
        //getSaatIni()
        TimePickerDialog(this,this,jam,menit,true).show()
    }


    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        jam = hourOfDay
        menit = minute

        teksWaktu = findViewById(R.id.time)
        teksWaktu.text = "${jam}:${menit}"
    }
}