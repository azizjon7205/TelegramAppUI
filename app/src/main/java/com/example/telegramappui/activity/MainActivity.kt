package com.example.telegramappui.activity

import android.graphics.Paint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.telegramappui.R
import com.example.telegramappui.adapter.ChatAdapter
import com.example.telegramappui.fragment.ChatFragment
import com.example.telegramappui.fragment.ContactFragment
import com.example.telegramappui.fragment.SettingsFragment
import com.example.telegramappui.model.Chat
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var bottomNavigationView: BottomNavigationView

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun initViews(){
        bottomNavigationView = findViewById(R.id.nav_bottom)

        replaceFragment(ContactFragment())
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_chats -> replaceFragment(ChatFragment())
                R.id.nav_contacts -> replaceFragment(ContactFragment())
                R.id.nav_settings -> replaceFragment(SettingsFragment())
            }
//            return@setOnNavigationItemSelectedListener true
            true
        }
        bottomNavigationView.getOrCreateBadge(R.id.nav_chats).apply {
            number = 6
            isVisible = true
        }

        bottomNavigationView.setBadge(R.id.nav_settings, "!")

//        val badgeDrawable = bottomNavigationView.getOrCreateBadge(R.id.nav_settings)
//        badgeDrawable.apply {
//            setContentView(R.layout.badge_settings)
//            isVisible = true
//        }


    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun BottomNavigationView.setBadge(tabResId: Int, badgeValue: String) {
        getOrCreateBadge(this, tabResId)?.let { badge ->
            badge.visibility = if (!badgeValue.isEmpty()) {
                badge.text = badgeValue
                badge.gravity = Gravity.CENTER
                badge.textAlignment = TextView.TEXT_ALIGNMENT_CENTER
                badge.setTextAppearance(com.google.android.material.R.style.TextAppearance_MaterialComponents_Badge)
                View.VISIBLE
            } else {
                View.GONE
            }
        }
    }

    fun getOrCreateBadge(bottomBar: View, tabResId: Int): TextView? {
        val parentView = bottomBar.findViewById<ViewGroup>(tabResId)
        return parentView?.let {
            var badge = parentView.findViewById<TextView>(R.id.menuItemBadge)
            if (badge == null) {
                LayoutInflater.from(parentView.context).inflate(R.layout.badge_settings, parentView, true)
                badge = parentView.findViewById(R.id.menuItemBadge)
            }
            badge
        }
    }

    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frame_frg, fragment)
            commit()
        }
    }

}