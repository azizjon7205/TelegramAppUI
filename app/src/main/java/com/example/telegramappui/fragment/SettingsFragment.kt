package com.example.telegramappui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.example.telegramappui.R
import com.example.telegramappui.activity.AppearanceActivity

class SettingsFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_settings, container, false)

        initViews(view)

        return view
    }

    private fun initViews(view: View){
        val lay_settings_notification = view.findViewById<LinearLayout>(R.id.lay_settings_notification)
        val lay_settings_appearance = view.findViewById<LinearLayout>(R.id.lay_settings_appearance)

        lay_settings_appearance.setOnClickListener {
            callAppearanceActivity()
        }
    }

    private fun callAppearanceActivity(){
        val intent = Intent(requireContext(), AppearanceActivity::class.java)
        startActivity(intent)
    }
}