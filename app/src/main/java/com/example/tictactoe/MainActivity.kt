package com.example.tictactoe

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.tictactoe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    val viewModel: AppViewModel by viewModels()
    var user = 1
    lateinit var sharedPreferences: SharedPreferences
    private val SETTINGS_CODE = 12334

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setAppTheme()
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.setThemeButton.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivityForResult(intent, SETTINGS_CODE)
        }

        binding.grid11.setOnClickListener {it as ImageButton
            onCageClicked(1, 1, it)
        }
        binding.grid12.setOnClickListener {it as ImageButton
            onCageClicked(1, 2, it)
        }
        binding.grid13.setOnClickListener {it as ImageButton
            onCageClicked(1, 3, it)
        }
        binding.grid21.setOnClickListener {it as ImageButton
            onCageClicked(2, 1, it)
        }
        binding.grid22.setOnClickListener {it as ImageButton
            onCageClicked(2, 2, it)
        }
        binding.grid23.setOnClickListener {it as ImageButton
            onCageClicked(2, 3, it)
        }
        binding.grid31.setOnClickListener {it as ImageButton
            onCageClicked(3, 1, it)
        }
        binding.grid32.setOnClickListener {it as ImageButton
            onCageClicked(3, 2, it)
        }
        binding.grid33.setOnClickListener {it as ImageButton
            onCageClicked(3, 3, it)
        }

    }

    private fun onCageClicked(row: Int, column: Int, button: ImageButton) {
        viewModel.set(row, column, user)
        if (user == 1) {
            button.setImageResource(R.drawable.o)
            user = 2
        } else {
            button.setImageResource(R.drawable.x)
            user = 1
        }

        val win = viewModel.winListener()
        if (win != 0) {
            val winner = win.toString()
            Toast.makeText(this, "User $winner wins", Toast.LENGTH_LONG).show()
        }
        viewModel.cages.observe(this, Observer {
            val gameState = it
            val i = 1
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == SETTINGS_CODE) {
            this.recreate()
        }
    }

    private fun setAppTheme() {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(baseContext)
        if (sharedPreferences.getString("color_option", "DARK THEME").equals("DARK THEME")) {
            setTheme(R.style.Theme_TicTacToe)
        } else {
            setTheme(R.style.GreenTheme_TicTacToe)
        }
    }
}