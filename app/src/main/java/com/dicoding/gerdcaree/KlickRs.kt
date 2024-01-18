package com.dicoding.gerdcaree

import android.content.Intent
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.tabs.TabLayout
import androidx.core.content.ContextCompat
import android.widget.ImageView
import android.widget.FrameLayout
import android.view.View



class KlickRs : AppCompatActivity() {
    private lateinit var helpImageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_klick_rs)
        ferguso()

        val backButton1: ImageView = findViewById(R.id.backButton1)
        val callAmbulanceTextView: TextView = findViewById(R.id.callAmbulance)
        val btncallambulane: FrameLayout = findViewById(R.id.btncallambulane)
        helpImageView = findViewById(R.id.helpImageView)
        btncallambulane.setOnClickListener {
            // Change the text when btncallambulane is clicked
            callAmbulanceTextView.text = "Help is on the way..."
            helpImageView.visibility = View.VISIBLE

            // Add any additional logic or actions you want to perform when the button is clicked
        }

        // Set an OnClickListener for the backButton1
        backButton1.setOnClickListener {
            // Start the new activity when backButton1 is clicked
//            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    private fun ferguso() {
        val tabLayout: TabLayout = findViewById(R.id.menu_bawah_actdua)
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.record), 0)
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.home), 1)
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.profile), 2)

        tabLayout.getTabAt(0)?.icon?.setColorFilter(
            ContextCompat.getColor(this, R.color.pink),
            PorterDuff.Mode.SRC_IN
        )
        tabLayout.getTabAt(1)?.icon?.setColorFilter(
            ContextCompat.getColor(this, R.color.gray),
            PorterDuff.Mode.SRC_IN
        )
        tabLayout.getTabAt(2)?.icon?.setColorFilter(
            ContextCompat.getColor(this, R.color.gray),
            PorterDuff.Mode.SRC_IN
        )

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                when (tab.position) {
                    0 -> {
                        startActivity(Intent(this@KlickRs, ReadRegistration::class.java))
                    }

                    1 -> {
                        startActivity(Intent(this@KlickRs, HomePage::class.java))
                    }

                    2 -> {
                        startActivity(Intent(this@KlickRs, ProfileActivity::class.java))
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                tab.icon?.setColorFilter(
                    ContextCompat.getColor(this@KlickRs, R.color.gray),
                    PorterDuff.Mode.SRC_IN
                )
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
                // Handle the reselection as needed
            }
        })
    }
}