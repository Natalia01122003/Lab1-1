package com.example.testlab3

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val text: TextView = findViewById(R.id.text)
        val button: Button = findViewById(R.id.button)
        val resultText: TextView = findViewById(R.id.resultText)

        button.setOnClickListener {
            val inputText = text.text.toString()
            val count = countLatinLetters(inputText)
            resultText.text = "Количество латинских букв: $count"
        }
    }

    private fun countLatinLetters(input: String): Int {
        return input.count { it in 'A'..'Z' || it in 'a'..'z' }
        }
}
