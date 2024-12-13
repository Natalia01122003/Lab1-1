package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }


        var sum: TextView = findViewById(R.id.sum1)
        var poslslag: TextView = findViewById(R.id.poslslag1)
        var iterations: TextView = findViewById(R.id.kolvoPovtor1)
        var persons_date: TextView = findViewById(R.id.person_date)
        val dates = persons_date.text.toString().toDoubleOrNull() ?:0.0
        var calculate: Button = findViewById(R.id.calc)


//        val dateString = persons_date.text.toString()
//        val date = dateString.toDoubleOrNull()
//
//        if (date == null) {
//            Toast.makeText(this, "Введите корректное число", Toast.LENGTH_SHORT).show()
//            return
//        }


        calculate.setOnClickListener {
            Toast.makeText(this, "Кнопка нажата", Toast.LENGTH_SHORT).show()

            var sum1 = 1.0
            var poslslag1: Double
            var iteration = 0
            var n = 2

            do {
                poslslag1 = 1.0 / (n*n)
                sum1 += poslslag1
                iteration++
                n++

//                if (iteration > 1000) {
//                    Toast.makeText(this, "Цикл слишком долгий", Toast.LENGTH_SHORT).show()
//
//                }
                Log.d("DEBUG", "Сумма: $sum1, Последнее слагаемое: $poslslag1, Количество: $iteration")

            } while (Math.abs(poslslag1) > dates)

            sum.text = "Сумма: $sum1"
            poslslag.text = "Последнее слагаемое: $poslslag1"
            iterations.text = "Количество повторений цикла: $iteration"

            //отладка
            Log.d("DEBUG", "Сумма: $sum1, Последнее слагаемое: $poslslag1, Количество: $iteration")
        }
    }
}