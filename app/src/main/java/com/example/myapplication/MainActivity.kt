package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var questions: ArrayList<Question>
    var position = 0
    lateinit var btYes: Button
    lateinit var btNo: Button
    lateinit var tvSentence: TextView
    lateinit var btNext: Button
    lateinit var tvPoint: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btYes = findViewById(R.id.btYes)
        btNo = findViewById(R.id.btNo)
        tvSentence = findViewById(R.id.tvSentence)
        btNext = findViewById(R.id.btNext)
        tvPoint = findViewById(R.id.tvPoints)
        loadQuestions()
        setupViews()
    }

    fun loadQuestions() {
        questions = ArrayList()
        questions.add(Question("¿La capital de Francia es París?", true))
        questions.add(Question("¿La capital de España es Barcelona?", false))
        questions.add(Question("¿La capital de Italia es Roma?", true))
        questions.add(Question("¿La capital de Japón es Tokio?", true))
        questions.add(Question("¿La capital de Canadá es Toronto?", false))
        questions.add(Question("¿La capital de Australia es Sídney?", false))
        questions.add(Question("¿La capital de México es Ciudad de México?", true))
        questions.add(Question("¿La capital de Brasil es Sao Paulo?", false))
        questions.add(Question("¿La capital de Alemania es Berlín?", true))
        questions.add(Question("¿La capital de Argentina es Buenos Aires?", true))
    }



    private fun setupViews() {
        showSentence()

        btYes.setOnClickListener {
            if(questions[position].answer){
                Toast.makeText(this, "Correcto", Toast.LENGTH_LONG).show()
                correctAnswer()
            }
            else {
                Toast.makeText(this, "Incorrecto", Toast.LENGTH_LONG).show()
            }
        }

        btNo.setOnClickListener {
            if(!questions[position].answer){
                Toast.makeText(this, "Correcto", Toast.LENGTH_LONG).show()
                correctAnswer()
            }
            else {
                Toast.makeText(this, "Incorrecto", Toast.LENGTH_LONG).show()
            }
        }

    }

    private fun showSentence() {
        tvPoint.text = "Puntos: $position"
        tvSentence.text = questions[position].sentence
    }

    private fun correctAnswer(){
            position++
            if (position < questions.size) {
                showSentence()
            } else {
                Toast.makeText(this, "Has respondido todas las preguntas", Toast.LENGTH_LONG).show()
            }
    }
}
