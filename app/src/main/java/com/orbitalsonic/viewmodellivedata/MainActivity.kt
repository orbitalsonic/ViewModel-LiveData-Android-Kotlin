package com.orbitalsonic.viewmodellivedata

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var counterViewModel: CounterViewModel
    private var number = 1

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        counterViewModel =
            ViewModelProvider(this).get(CounterViewModel::class.java)

        val textViewCounter:TextView = findViewById(R.id.tv_count)
        val btnNextCount:Button = findViewById(R.id.btn_next_count)
        btnNextCount.setOnClickListener {
            counterViewModel.setCounter(number++)
        }

        counterViewModel.setCounter(number++)
        counterViewModel.counterNumber.observe(this, {
            textViewCounter.text = "This is counter number : $it"
        })


    }
}