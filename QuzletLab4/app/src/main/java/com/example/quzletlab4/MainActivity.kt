package com.example.quzletlab4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var questionTextView: TextView
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: Button
    private lateinit var resultTextView: TextView
    private lateinit var cheatButton: Button

    private val viewModel: QuestionViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        questionTextView = findViewById(R.id.question_text_view)
        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)
        nextButton = findViewById(R.id.next_button)
        resultTextView = findViewById(R.id.result_text_view)
        cheatButton = findViewById(R.id.cheat_button)

        trueButton.setOnClickListener {
            checkAnswer(true)
        }

        falseButton.setOnClickListener {
            checkAnswer(false)
        }

        nextButton.setOnClickListener {
            viewModel.moveToNext()
            updateQuestion()
        }

        cheatButton.setOnClickListener {
            startCheatActivity()
        }

        // Обновить вопрос при загрузке
        updateQuestion()
    }

    private fun updateQuestion() {
        val question = viewModel.getQuestion()
        questionTextView.setText(question.textResId)

        // Делаем кнопки видимыми после выбора ответа
        trueButton.visibility = Button.VISIBLE
        falseButton.visibility = Button.VISIBLE
        nextButton.visibility = Button.VISIBLE
        resultTextView.text = ""

        // Если последний вопрос, то скрыть кнопку "Next"
        if (viewModel.currentIndex == viewModel.questionBank.size - 1) {
            nextButton.visibility = Button.GONE
        }
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = viewModel.getQuestion().answer
        val messageResId: Int

        if (userAnswer == correctAnswer) {
            messageResId = R.string.correct_toast
            viewModel.markAnswer(true)
        } else {
            messageResId = R.string.incorrect_toast
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show()

        // Скрытие кнопок после ответа
        trueButton.visibility = Button.GONE
        falseButton.visibility = Button.GONE

        // Обновление результата
        if (viewModel.currentIndex == viewModel.questionBank.size - 1) {
            resultTextView.text = getString(R.string.correct_count, viewModel.correctAnswersCount)
        }
    }

    // Сохранение состояния активности
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("currentIndex", viewModel.currentIndex)
        outState.putInt("correctAnswersCount", viewModel.correctAnswersCount)
        outState.putInt("cheatCount", viewModel.cheatCount)
    }

    // Восстановление состояния активности
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        viewModel.currentIndex = savedInstanceState.getInt("currentIndex", 0)
        viewModel.correctAnswersCount = savedInstanceState.getInt("correctAnswersCount", 0)
        viewModel.cheatCount = savedInstanceState.getInt("cheatCount", 0)
        updateQuestion()
    }

    // Добавление функции запуска второй активности
    private fun startCheatActivity() {
        val intent = Intent(this, CheatActivity::class.java)
        startActivity(intent)
    }
}