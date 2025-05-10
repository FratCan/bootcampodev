package com.example.simplecalculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.hesapmakinesiodev5.R

class MainActivity : AppCompatActivity() {

    private lateinit var tvResult: TextView
    private var firstNumber = 0
    private var secondNumber = 0
    private var isPlusPressed = false
    private var currentInput = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvResult = findViewById(R.id.tvResult)

        val numberButtons = listOf(
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
            R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9
        )

        numberButtons.forEach { id ->
            findViewById<Button>(id).setOnClickListener {
                val value = (it as Button).text.toString()
                currentInput += value
                tvResult.text = currentInput
            }
        }

        findViewById<Button>(R.id.btnPlus).setOnClickListener {
            if (currentInput.isNotEmpty()) {
                firstNumber = currentInput.toInt()
                currentInput = ""
                isPlusPressed = true
                tvResult.text = ""
            }
        }

        findViewById<Button>(R.id.btnEqual).setOnClickListener {
            if (isPlusPressed && currentInput.isNotEmpty()) {
                secondNumber = currentInput.toInt()
                val result = firstNumber + secondNumber
                tvResult.text = result.toString()

                // Reset durum
                currentInput = ""
                firstNumber = 0
                secondNumber = 0
                isPlusPressed = false
            }
        }

        findViewById<Button>(R.id.btnReset).setOnClickListener {
            currentInput = ""
            firstNumber = 0
            secondNumber = 0
            isPlusPressed = false
            tvResult.text = "0"
        }
    }
}
