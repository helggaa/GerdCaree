package com.dicoding.gerdcaree

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.gerdcaree.R

class ProfileActivity : AppCompatActivity() {

    // Declare backgroundOverlay at the class level
    private lateinit var backgroundOverlay: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val logoutTextView: TextView = findViewById(R.id.logoutTextView)

        // Find and initialize backgroundOverlay
        backgroundOverlay = findViewById(R.id.backgroundOverlay)

        logoutTextView.setOnClickListener {
            showFloatingWindow(it)
            // Set the visibility of backgroundOverlay to View.VISIBLE when the popup is shown
            backgroundOverlay.visibility = View.VISIBLE
        }
    }

    private fun showFloatingWindow(anchorView: View) {
        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.popup_layout, null)

        val popupWindow = PopupWindow(
            view,
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT,
            true
        )

        // Set up the close button inside the popup window
        view.findViewById<View>(R.id.cancenlog).setOnClickListener {
            popupWindow.dismiss()
            // Set the visibility of backgroundOverlay to View.GONE when the popup is dismissed
            backgroundOverlay.visibility = View.GONE
        }

        // Show the popup window
        popupWindow.showAsDropDown(anchorView, -110, -800)
    }
}