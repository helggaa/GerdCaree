package com.dicoding.gerdcaree

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import com.dicoding.gerdcaree.R
import java.util.Calendar

class addmedicinereminder : AppCompatActivity() {
    private lateinit var iStartSchedule: EditText
    private lateinit var iEndSchedule: EditText
    private lateinit var datePickerDialog: DatePickerDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addmedicinereminder)

        // initiate the date picker and a button
        iStartSchedule = findViewById(R.id.iStartSchedule)
        iEndSchedule = findViewById(R.id.iEndSchedule)
        lateinit var imageButton: ImageButton

        imageButton = findViewById(R.id.bPlus) as ImageButton
        val backButtonmed: ImageView = findViewById(R.id.backButton)

        // Set an OnClickListener for the backButton1
        backButtonmed.setOnClickListener {
            // Start the new activity when backButton1 is clicked
            finish()
        }

        // perform click event on edit text
        iStartSchedule.setOnClickListener {
            // calender class's instance and get current date , month and year from calender
            val c = Calendar.getInstance()
            val mYear = c.get(Calendar.YEAR) // current year
            val mMonth = c.get(Calendar.MONTH) // current month
            val mDay = c.get(Calendar.DAY_OF_MONTH) // current day

            // date picker dialog
            datePickerDialog = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { view: DatePicker, year: Int, monthOfYear: Int, dayOfMonth: Int ->
                    // set day of month , month and year value in the edit text
                    iStartSchedule.setText("$dayOfMonth/${monthOfYear + 1}/$year")
                },
                mYear,
                mMonth,
                mDay
            )
            datePickerDialog.show()
        }

        iEndSchedule.setOnClickListener {
            // calender class's instance and get current date , month and year from calender
            val c = Calendar.getInstance()
            val mYear = c.get(Calendar.YEAR) // current year
            val mMonth = c.get(Calendar.MONTH) // current month
            val mDay = c.get(Calendar.DAY_OF_MONTH) // current day

            // date picker dialog
            datePickerDialog = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { view: DatePicker, year: Int, monthOfYear: Int, dayOfMonth: Int ->
                    // set day of month , month and year value in the edit text
                    iEndSchedule.setText("$dayOfMonth/${monthOfYear + 1}/$year")
                },
                mYear,
                mMonth,
                mDay
            )
            datePickerDialog.show()
        }
    }
}