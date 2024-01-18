package com.dicoding.gerdcaree

import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.google.android.material.tabs.TabLayout
import androidx.core.content.ContextCompat
import android.content.Intent
import android.widget.FrameLayout
import com.dicoding.gerdcaree.databinding.ActivityAmbulance1Binding

class AmbulanceActivity : AppCompatActivity() {

    private lateinit var tabLayout: TabLayout

    private lateinit var binding: ActivityAmbulance1Binding // Use the correct binding class
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_ambulance) // Remove this line, as it's redundant when using DataBinding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_ambulance1)
        initUI()
        ferguso()
        setupFrameLayoutClickListeners()
    }
    private fun setupFrameLayoutClickListeners() {
        val rmSatu: FrameLayout = findViewById(R.id.rm_satu)
        val rmDua: FrameLayout = findViewById(R.id.rm_dua)

        rmSatu.setOnClickListener {
            // Start the new activity for FrameLayout rm_satu
            startActivity(Intent(this, KlickRs::class.java))
        }

//        rmDua.setOnClickListener {
//            // Start the new activity for FrameLayout rm_dua
//            startActivity(Intent(this, AnotherNewActivity::class.java))
//        }
    }
    private fun initUI(){
        binding.menuAtas.backButton.setOnClickListener{
            Toast.makeText(this, "Back button clicked",Toast.LENGTH_SHORT).show()
            finish()
        }
        binding.menuAtas.titikTiga.setOnClickListener{
            Toast.makeText(this, "More",Toast.LENGTH_SHORT).show()
        }
        binding.menuAtas.titleAmb.text = "Ambulance Service"
    }
    private fun ferguso() {
        val tabLayout: TabLayout = findViewById(R.id.menu_bawah)
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
                        startActivity(Intent(this@AmbulanceActivity, ReadRegistration::class.java))
                    }
                    1 -> {
                        startActivity(Intent(this@AmbulanceActivity, HomePage::class.java))
                    }
                    2 ->{
                        startActivity(Intent(this@AmbulanceActivity, ProfileActivity::class.java))
                    }
                }
                for (i in 0 until tabLayout.tabCount) {
                    val currentTab = tabLayout.getTabAt(i)
                    if (currentTab == tab) {
                        currentTab?.icon?.setColorFilter(
                            ContextCompat.getColor(this@AmbulanceActivity, R.color.pink),
                            PorterDuff.Mode.SRC_IN
                        )
                    } else {
                        currentTab?.icon?.setColorFilter(
                            ContextCompat.getColor(this@AmbulanceActivity, R.color.gray),
                            PorterDuff.Mode.SRC_IN
                        )
                    }
                }

            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                tab.icon?.setColorFilter(
                    ContextCompat.getColor(this@AmbulanceActivity, R.color.gray),
                    PorterDuff.Mode.SRC_IN
                )
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
                // Handle the reselection as needed
            }
        })
    }

}