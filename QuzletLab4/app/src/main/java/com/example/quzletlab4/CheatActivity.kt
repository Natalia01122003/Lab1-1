package com.example.quzletlab4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity

class CheatActivity : AppCompatActivity() {
    private lateinit var answerTextView: TextView
    private lateinit var apiVersionTextView: TextView
    private lateinit var showAnswerButton: Button

    private val viewModel: QuestionViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cheat)

        answerTextView = findViewById(R.id.answer_text_view)
        apiVersionTextView = findViewById(R.id.api_version_text_view)
        showAnswerButton = findViewById(R.id.show_answer_button)

        val apiVersion = android.os.Build.VERSION.SDK_INT
        apiVersionTextView.text = "API Version: $apiVersion"

        showAnswerButton.setOnClickListener {
            if (viewModel.canCheat()) {
                answerTextView.text = if (viewModel.getQuestion().answer) "Правда" else "Ложь"
                viewModel.cheatUsed()
            } else {
                answerTextView.text = "Подсказка исчерпана"
            }
        }
    }
}