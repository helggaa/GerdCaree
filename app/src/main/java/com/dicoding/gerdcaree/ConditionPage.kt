package com.dicoding.gerdcaree

import android.app.Dialog
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import com.google.android.material.tabs.TabLayout


class ConditionPage : AppCompatActivity() {
    private val CHANNEL_ID = "channel_id_example_01"
    private val notificationId = 101
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_condition)

        val submitButton: Button = findViewById(R.id.submitbtn)

        createNotificationChannel()

        ferguso()
        val backButtonmed: ImageView = findViewById(R.id.backButton)

        // Set an OnClickListener for the backButton1
        backButtonmed.setOnClickListener {
            // Start the new activity when backButton1 is clicked
            finish()
        }


        submitButton.setOnClickListener {
            showPopup()
        }
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "GerdCare Condition Record"
            val descriptionText = "Your condition is bad, you need to take a deep breath to netralize your feeling before continue your job"
            val importance: Int = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }

            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager?.createNotificationChannel(channel)
        }
    }

    private fun sendNotification() {
        val builder: NotificationCompat.Builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("Example Title")
            .setContentText("Example Description")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        val notificationManagerCompat = NotificationManagerCompat.from(this)

        Log.d("NotificationDebug", "Builder: ${builder.build()}")
        Log.d("NotificationDebug", "ManagerCompat: $notificationManagerCompat")
        Log.d("NotificationDebug", "NotificationId: $notificationId")

        notificationManagerCompat ?: run {
            Log.e("NotificationDebug", "NotificationManagerCompat is null")
            return
        }

        try {
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.notify(notificationId, builder.build())
            Log.d("NotificationDebug", "Notification sent successfully")
        } catch (e: Exception) {
            Log.e("NotificationDebug", "Error sending notification: ${e.message}")
            e.printStackTrace()
        }
    }

    private fun showPopup() {
        val dialog = Dialog(this)

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.conditionpopup)

        val okeButton: Button = dialog.findViewById(R.id.okeButton)

        okeButton.setOnClickListener {
            sendNotification()
            dialog.dismiss()
        }

        dialog.show()
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
                        startActivity(Intent(this@ConditionPage, ReadRegistration::class.java))
                    }
                    1 -> {
                        startActivity(Intent(this@ConditionPage, HomePage::class.java))
                    }
                    2 ->{
                        startActivity(Intent(this@ConditionPage, ProfileActivity::class.java))
                    }
                }
                for (i in 0 until tabLayout.tabCount) {
                    val currentTab = tabLayout.getTabAt(i)
                    if (currentTab == tab) {
                        currentTab?.icon?.setColorFilter(
                            ContextCompat.getColor(this@ConditionPage, R.color.pink),
                            PorterDuff.Mode.SRC_IN
                        )
                    } else {
                        currentTab?.icon?.setColorFilter(
                            ContextCompat.getColor(this@ConditionPage, R.color.gray),
                            PorterDuff.Mode.SRC_IN
                        )
                    }
                }

            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                tab.icon?.setColorFilter(
                    ContextCompat.getColor(this@ConditionPage, R.color.gray),
                    PorterDuff.Mode.SRC_IN
                )
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
                // Handle the reselection as needed
            }
        })
    }
}