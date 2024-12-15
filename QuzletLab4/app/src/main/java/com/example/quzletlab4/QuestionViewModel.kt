package com.example.quzletlab4

import androidx.lifecycle.ViewModel

class QuestionViewModel : ViewModel() {
    var currentIndex = 0
    var correctAnswersCount = 0
    var cheatCount = 0

    internal val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, true),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true)
    )

    fun getQuestion(): Question {
        return questionBank[currentIndex]
    }

    fun moveToNext() {
        if (currentIndex < questionBank.size - 1) {
            currentIndex++
        }
    }

    fun markAnswer(correct: Boolean) {
        if (correct) correctAnswersCount++
    }

    fun canCheat(): Boolean {
        return cheatCount < 3
    }

    fun cheatUsed() {
        cheatCount++
    }
}