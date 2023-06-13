package com.example.tictactoe

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity : AppCompatActivity(), SharedPreferences.OnSharedPreferenceChangeListener {

    var sharedPref: SharedPreferences? = null
    var editor: SharedPreferences.Editor? = null
    var blueThemButton: LinearLayout? = null
    var purpleThemButton: LinearLayout? = null
    var pinkThemButton: LinearLayout? = null
    var beigeThemButton: LinearLayout? = null
    var greenThemButton: LinearLayout? = null
    var blackThemButton: LinearLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPref = getSharedPreferences("themePref", Context.MODE_PRIVATE)
        editor = sharedPref?.edit()
        val appTheme = sharedPref?.getString("themName", "DARK THEM")
        val themRef = getThem(appTheme)
        setTheme(themRef)
        setContentView(R.layout.settings_activity)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        blueThemButton = findViewById(R.id.blueThemeButton)
        purpleThemButton = findViewById(R.id.purpleThemeButton)
        pinkThemButton = findViewById(R.id.pinkThemeButton)
        beigeThemButton = findViewById(R.id.beigeThemeButton)
        greenThemButton = findViewById(R.id.greenThemeButton)
        blackThemButton = findViewById(R.id.blackThemeButton)

        blueThemButton?.setOnClickListener {
            setAppTheme("BLUE THEME")
            updateAppTheme()
        }
        purpleThemButton?.setOnClickListener {
            setAppTheme("PURPLE THEME")
            updateAppTheme()
        }
        pinkThemButton?.setOnClickListener {
            setAppTheme("PINK THEME")
            updateAppTheme()
        }
        beigeThemButton?.setOnClickListener {
            setAppTheme("BEIGE THEME")
            updateAppTheme()
        }
        greenThemButton?.setOnClickListener {
            setAppTheme("GREEN THEME")
            updateAppTheme()
        }
        blackThemButton?.setOnClickListener {
            setAppTheme("DARK THEM")
            updateAppTheme()
        }

    }

    private fun updateAppTheme() {
        this.recreate()
    }

    private fun setAppTheme(themName: String) {
        editor?.apply {
            putString("themName", themName)
            apply()
        }
    }

    private fun getThem(themeName: String?): Int {
        return when (themeName) {
            "BEIGE THEME" -> R.style.BeigeTheme_TicTacToe
            "GREEN THEME" -> R.style.GreenTheme_TicTacToe
            "BLUE THEME" -> R.style.BlueTheme_TicTacToe
            "PINK THEME" -> R.style.PinkTheme_TicTacToe
            "PURPLE THEME" -> R.style.PurpleTheme_TicTacToe
            else -> R.style.Theme_TicTacToe
        }
    }

    override fun onSharedPreferenceChanged(p0: SharedPreferences?, p1: String?) {
        if (p1.equals("color_option")) {
            this.recreate()
        }
    }
}