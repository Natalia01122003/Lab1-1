package com.example.lab1

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            //val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            //v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            //insets
        //}



        //создаем переменные var val

        var label: TextView = findViewById(R.id.main_label)
        val userD: TextView = findViewById(R.id.user_data)
        var userData: Int = userD.text.toString().toIntOrNull() ?:0 //из строки преобразуем в число, задаем значение по умолочанию 0
        var button:Button = findViewById(R.id.button)               // операто ?: исп для созд знач по умолочанию
        var textN: TextView = findViewById(R.id.textned)



        button.setOnClickListener {
            Toast.makeText(this, "Кнопка нажата", Toast.LENGTH_SHORT).show()

            userData = userD.text.toString().toIntOrNull() ?:0 //обновляем каждый раз строку
            when(userData) {                // оператор when используется вместо if and elso
                1 -> textN.text = "Понедельник"
                2 -> textN.text = "Вторник"
                3 -> textN.text = "Среда"
                4 -> textN.text = "Четверг"
                5 -> textN.text = "Пятница"
                6 -> textN.text = "Суббота"
                7 -> textN.text = "Воскресенье"
                else -> textN.text = "Неверный ввод"
            }
        }
    }
}