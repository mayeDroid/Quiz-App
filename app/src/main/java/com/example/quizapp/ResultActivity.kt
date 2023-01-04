package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val username = intent.getStringExtra(ConstantQuestions.USER_NAME)
        textViewUserName.text = username

        val totalQuestions = intent.getIntExtra(ConstantQuestions.TOTAL_QUESTIONS, 0)
        val correctAnswers = intent.getIntExtra(ConstantQuestions.CORRECT_ANSWERS, 0)

        textViewScore.text = "Your score is $correctAnswers out of $totalQuestions"

        buttonFinish.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}