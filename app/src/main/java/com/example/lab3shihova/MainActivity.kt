package com.example.lab3shihova

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputText = findViewById<EditText>(R.id.inputText)
        val reverseButton = findViewById<Button>(R.id.reverseButton)
        val resultText = findViewById<TextView>(R.id.resultText)

        reverseButton.setOnClickListener {
            val original = inputText.text.toString()

            if (original.isEmpty()) {
                resultText.text = "Введите текст!"
                return@setOnClickListener
            }

            val reversed = reverseString(original)
            resultText.text = reversed
        }
    }

    private fun reverseString(input: String): String {
        val chars = input.toCharArray()
        var left = 0
        var right = chars.size - 1

        while (left < right) {
            val temp = chars[left]
            chars[left] = chars[right]
            chars[right] = temp
            left++
            right--
        }

        return String(chars)
    }
}