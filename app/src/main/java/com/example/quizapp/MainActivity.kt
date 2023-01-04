package com.example.quizapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import kotlinx.android.synthetic.main.activity_main.*

// before starting changed orientation in manifest, inserted our new theme style created and added to portrait only
// We also added a soft windows input to which adjust keyboard size to fit the window
// Then we created a a new theme style

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // If the Edit Text is empty it should not go to the next page

        button.setOnClickListener {
            if (edit_text.text.toString().isEmpty()){
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
            }
            else{
                val intent = Intent(this, QuestionsActivity::class.java)
                intent.putExtra(ConstantQuestions.USER_NAME, edit_text.text.toString())
                startActivity(intent)
                finish()

            }
        }


    }
}