package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_questions.*

// before starting changed orientation in manifest, inserted our new theme style created and added to portrait only

class QuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private  var myCurrentPosition: Int = 1
    private var myQuestionsList: ArrayList<Questions>? = null
    private var mySelectedOptionsPosition:Int = 0
    private var noOfCorrectAnswers: Int = 0
    private var myUserName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        myUserName = intent.getStringExtra(ConstantQuestions.USER_NAME)

        myQuestionsList = ConstantQuestions.getQuestions() // This calls the getQuestions function created in the ConstantQuestions class
        Log.i("Questions Size", "${myQuestionsList!!.size}") // We use the logcat to get the questions list

        setQuestions()

        textV_option_one.setOnClickListener(this)

// if we don't want to use the onClick function
        textV_option_two.setOnClickListener (this)
        textV_option_three.setOnClickListener(this)
        textV_option_four.setOnClickListener(this)

        button_submit.setOnClickListener(this)
    }

    private fun setQuestions(){

        val questions = myQuestionsList!![myCurrentPosition - 1]
        defaultQuestionsOptionsView()

 // Here is there are still questions to take we set the button back to submit, when theres none it goes to finish
        if(myCurrentPosition == myQuestionsList!!.size){
            button_submit.text = "FINISH"
        }
        else{
            button_submit.text = "SUBMIT"
        }

        // here we enable the progress bar
        progressbar.progress = myCurrentPosition
        textV_progress_bar.text = "$myCurrentPosition" + "/" + "${progressbar.max}"

        textVQuestions.text = questions!!.questions
        iv_image.setImageResource(questions.image)
        textV_option_one.text = questions.optionOne
        textV_option_two.text = questions.optionTwo
        textV_option_three.text = questions.optionThree
        textV_option_four.text = questions.optionFour
    }

    /**
     * A function to set default options view when the new question is loaded or when the answer is reselected.
     */

    private fun defaultQuestionsOptionsView (){
        val options = ArrayList<TextView>()
        options.add(0,textV_option_one)
        options.add(1,textV_option_two)
        options.add(2,textV_option_three)
        options.add(3, textV_option_four)

        for(questionsOptionsStyle in options){
            questionsOptionsStyle.setTextColor(Color.parseColor("#7a8089"))
            questionsOptionsStyle.typeface = Typeface.DEFAULT
            questionsOptionsStyle.background = ContextCompat.getDrawable(this,
                R.drawable.options_background)


        }

    }

 // This function was created cos we inherited from the Onclick listener, and we used it cos we want to reduce boiler plate
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.textV_option_one -> {
                selectedOptionsView(textV_option_one, 1)
            }
            R.id.textV_option_two -> {
                selectedOptionsView(textV_option_two, 2)
            }
            R.id.textV_option_three -> {
                selectedOptionsView(textV_option_three, 3)
            }
            R.id.textV_option_four -> {
                selectedOptionsView(textV_option_four, 4)
            }

            R.id.button_submit -> {
                if (mySelectedOptionsPosition == 0){
                    myCurrentPosition++

                    when{
                        myCurrentPosition <= myQuestionsList!!.size ->{
                            setQuestions()
                        }
                        else -> {
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(ConstantQuestions.USER_NAME, myUserName)
                            intent.putExtra(ConstantQuestions.CORRECT_ANSWERS, noOfCorrectAnswers)
                            intent.putExtra(ConstantQuestions.TOTAL_QUESTIONS, myQuestionsList!!.size)
                            startActivity(intent)
                            finish()

                        }
                    }
                }

                else {
                    val question = myQuestionsList?.get(myCurrentPosition -1)

                    // This is to check if the answer is wrong
                    if (question!!.correctAnswer != mySelectedOptionsPosition){
                        answersView(mySelectedOptionsPosition,R.drawable.wrong_option_border)
                    }
                    else{
                        noOfCorrectAnswers++   // anytime the answer is correct it will keep increasing
                    }

                    // This is for correct answer
                    answersView(question.correctAnswer, R.drawable.correct_options_border)

                    if (myCurrentPosition == myQuestionsList!!.size){
                        button_submit.text = "FINISH"
                    }
                    else {
                        button_submit.text = "GO TO NEXT QUESTION"
                    }
                    mySelectedOptionsPosition = 0
                }
            }
        }
    }


// when we click an option we want it to display in a different way
    /**
     * A function to set the view of selected option view.
     */
    private fun selectedOptionsView(textView: TextView, selectedOptionsNumber: Int){
        defaultQuestionsOptionsView()
        mySelectedOptionsPosition = selectedOptionsNumber
        textView.setTextColor(Color.parseColor("#363a43"))
        textView.setTypeface(textView.typeface, Typeface.BOLD)
        textView.background = ContextCompat.getDrawable(this,
            R.drawable.selected_options_border)
    }

//   Takes care of assigning the right colour background to our options
    private fun answersView(answer: Int, drawableView: Int){
        when(answer){
            1 -> {
                textV_option_one.background = ContextCompat.getDrawable(this, drawableView)
            }

            2 -> {
                textV_option_two.background = ContextCompat.getDrawable(this, drawableView)
            }

            3 -> {
                textV_option_three.background = ContextCompat.getDrawable(this, drawableView)
            }

            4 -> {
                textV_option_four.background = ContextCompat.getDrawable(this, drawableView)
            }


        }
    }
}