package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.tictactoe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    val viewModel: AppViewModel by viewModels()
    var user = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

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

    fun onCageClicked(row: Int, column: Int, button: ImageButton) {
        viewModel.set(row, column)
        if (user == 1) {
            button.setImageResource(R.drawable.o)
            user = 2
        } else {
            button.setImageResource(R.drawable.x)
            user = 1
        }
        viewModel.cages.observe(this, Observer {
            val gameState = it
            val i = 1
        })
    }
}