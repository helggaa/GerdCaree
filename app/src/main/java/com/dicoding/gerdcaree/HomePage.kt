package com.dicoding.gerdcaree

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import androidx.core.content.ContextCompat
import android.content.Intent
import android.graphics.PorterDuff
import android.widget.FrameLayout
import android.widget.ImageButton


class HomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        ferguso()
        val fAtas: FrameLayout = findViewById(R.id.fAtas)
        val mealhome: FrameLayout = findViewById(R.id.mealhome)
        val myconditionhome: FrameLayout = findViewById(R.id.myconditionhome)
        val ambulancehome: FrameLayout = findViewById(R.id.ambulancehome)
        val medicinehome: FrameLayout = findViewById(R.id.medicinehome)
        val MyConditiondoc: ImageButton = findViewById(R.id.MyConditiondoc)

        fAtas.setOnClickListener {
            val intent = Intent(this@HomePage, AlarmAct::class.java)
            startActivity(intent)
        }
        mealhome.setOnClickListener {
            val intent = Intent(this@HomePage, AlarmAct::class.java)
            startActivity(intent)
        }
        myconditionhome.setOnClickListener {
            val intent = Intent(this@HomePage, ConditionPage::class.java)
            startActivity(intent)
        }
        ambulancehome.setOnClickListener {
            val intent = Intent(this@HomePage, AmbulanceActivity::class.java)
            startActivity(intent)
        }
        medicinehome.setOnClickListener {
            val intent = Intent(this@HomePage, MedicineReminder::class.java)
            startActivity(intent)
        }
        MyConditiondoc.setOnClickListener {
            val intent = Intent(this@HomePage, ConditionPage::class.java)
            startActivity(intent)
        }


    }
    private fun ferguso() {
        val tabLayout: TabLayout = findViewById(R.id.menu_bawah_actdua)
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
                        startActivity(Intent(this@HomePage, ReadRegistration::class.java))
                    }
                    2 ->{
                        startActivity(Intent(this@HomePage, ProfileActivity::class.java))
                    }
                }
                for (i in 0 until tabLayout.tabCount) {
                    val currentTab = tabLayout.getTabAt(i)
                    if (currentTab == tab) {
                        currentTab?.icon?.setColorFilter(
                            ContextCompat.getColor(this@HomePage, R.color.pink),
                            PorterDuff.Mode.SRC_IN
                        )
                    } else {
                        currentTab?.icon?.setColorFilter(
                            ContextCompat.getColor(this@HomePage, R.color.gray),
                            PorterDuff.Mode.SRC_IN
                        )
                    }
                }

            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                tab.icon?.setColorFilter(
                    ContextCompat.getColor(this@HomePage, R.color.gray),
                    PorterDuff.Mode.SRC_IN
                )
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
                // Handle the reselection as needed
            }
        })
    }
}