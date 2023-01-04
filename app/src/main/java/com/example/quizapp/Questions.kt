package com.example.quizapp

data class Questions(
    var id: Int,
    var questions: String,
    var optionOne: String,
    var optionTwo: String,
    var optionThree: String,
    var optionFour: String,
    var correctAnswer: Int,
    var image: Int,) {
}