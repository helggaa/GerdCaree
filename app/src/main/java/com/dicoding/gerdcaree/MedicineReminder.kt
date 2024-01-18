package com.dicoding.gerdcaree

import android.content.Intent
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import com.google.android.material.tabs.TabLayout
import com.dicoding.gerdcaree.R

class MedicineReminder : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_medicinereminder)

        lateinit var imageButton: ImageButton

        imageButton = findViewById(R.id.bPlus) as ImageButton
        val backButtonmed: ImageView = findViewById(R.id.backButton)

        // Set an OnClickListener for the backButton1
        backButtonmed.setOnClickListener {
            // Start the new activity when backButton1 is clicked
            finish()
        }

        imageButton.setOnClickListener {
            openActivity2()
        }
        bottomNavBar();
    }
    fun openActivity2() {
        val intent = Intent(this, addmedicinereminder::class.java)
        startActivity(intent)
    }

    private fun bottomNavBar() {
        val tabLayout: TabLayout = findViewById(R.id.bottom_navbar_menu)
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.document), 0)
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.home), 1)
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.profile), 2)

        tabLayout.getTabAt(0)?.icon?.setColorFilter(
            ContextCompat.getColor(this, R.color.gray),
            PorterDuff.Mode.SRC_IN
        )
        tabLayout.getTabAt(1)?.icon?.setColorFilter(
            ContextCompat.getColor(this, R.color.pink),
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
                        startActivity(Intent(this@MedicineReminder, ReadRegistration::class.java))
                    }
                    1 -> {
                        startActivity(Intent(this@MedicineReminder, HomePage::class.java))
                    }
                    2 ->{
                        startActivity(Intent(this@MedicineReminder, ProfileActivity::class.java))
                    }
                }
                for (i in 0 until tabLayout.tabCount) {
                    val currentTab = tabLayout.getTabAt(i)
                    if (currentTab == tab) {
                        currentTab?.icon?.setColorFilter(
                            ContextCompat.getColor(this@MedicineReminder, R.color.pink),
                            PorterDuff.Mode.SRC_IN
                        )
                    } else {
                        currentTab?.icon?.setColorFilter(
                            ContextCompat.getColor(this@MedicineReminder, R.color.gray),
                            PorterDuff.Mode.SRC_IN
                        )
                    }
                }

            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                tab.icon?.setColorFilter(
                    ContextCompat.getColor(this@MedicineReminder, R.color.gray),
                    PorterDuff.Mode.SRC_IN
                )
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
                // Handle the reselection as needed
            }
        })
    }
}