package com.dicoding.gerdcaree

import android.app.Dialog
import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class ReadRegistration : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read_registration)
        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        val intent = intent
        val name = sharedPreferences.getString("name", "")
        val medicineList = sharedPreferences.getString("medicineList", "")
        val birthdate = sharedPreferences.getString("birthdate", "")
        val weight = sharedPreferences.getInt("weight", 0)
        val height = sharedPreferences.getInt("height", 0)
        val gerdValue = sharedPreferences.getInt("gerdValue", 0)

        val selectedGenderId = sharedPreferences.getString("selectedGenderId", "")
        val selectedFrequencyId = sharedPreferences.getString("selectedFrequencyId", "")

//        val name = intent.getStringExtra("name")
//        val medicineList = intent.getStringExtra("medicineList")
//        val birthdate = intent.getStringExtra("birthdate")
//        val weight = intent.getIntExtra("weight", 0)
//        val height = intent.getIntExtra("height", 0)
//        val gerdValue = intent.getIntExtra("gerdValue", 0)
//
//        // Retrieve selected radio button values
//        val selectedGenderId = intent.getStringExtra("selectedGenderId")
//        val selectedFrequencyId = intent.getStringExtra("selectedFrequencyId")

        val deletebutton: Button = findViewById(R.id.delete)

        deletebutton.setOnClickListener {
            val message: String? = "Are you sure you want to delete?!"
            showCustomDialogBox(message)
        }

        val fullName = findViewById<TextView>(R.id.fullname)
        fullName.text = name

        val tvBirthdate = findViewById<TextView>(R.id.birthdate)
        tvBirthdate.text = birthdate

        val tvGender = findViewById<TextView>(R.id.gender)
        if (selectedGenderId != null) {
            tvGender.text = selectedGenderId
        }

        val tvWeight = findViewById<TextView>(R.id.weigth)
        tvWeight.text = weight.toString()

        val tvHeight = findViewById<TextView>(R.id.height)
        tvHeight.text = height.toString()

        val tvGerdValue = findViewById<TextView>(R.id.period)
        tvGerdValue.text = gerdValue.toString()

        val tvFrequency = findViewById<TextView>(R.id.symptomps)
        if (selectedFrequencyId != null) {
            tvFrequency.text = selectedFrequencyId
        }
        else{
            tvFrequency.text = "rusak"
        }

        val medicineLists = findViewById<TextView>(R.id.medlist)
        medicineLists.text = medicineList

        val btnLogOut: Button = findViewById(R.id.delete)

    }

    private fun showCustomDialogBox(message: String?) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.alert)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val tvMessage: TextView = dialog.findViewById(R.id.tvMessage)
        val btnYes: Button = dialog.findViewById(R.id.btnYes)
        val btnNo: Button = dialog.findViewById(R.id.btnNo)

        tvMessage.text = message

        btnYes.setOnClickListener {
            // Clear all data in sharedPreferences
            sharedPreferences.edit().clear().apply()
            Toast.makeText(this, "Data deleted", Toast.LENGTH_LONG).show()
            dialog.dismiss()
        }

        btnNo.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }

}