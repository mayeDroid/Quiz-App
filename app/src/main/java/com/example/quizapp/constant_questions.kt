package com.example.quizapp

object ConstantQuestions{

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions(): ArrayList<Questions> {
    val questionsList = ArrayList<Questions>()

        val question1 = Questions(1,
            "which country's flag is this?",
            "Nigeria" ,
            "Ghana",
            "Togo",
            "Benin",
            1,
            image = R.drawable.ic_flag_of_nig)
        questionsList.add(question1)

        val question2 = Questions(2,
            "which country's flag is this?",
            "Nigeria" ,
            "Spain",
            "Australia",
            "Argentina",
            3,
            image = R.drawable.ic_flag_of_australia)
        questionsList.add(question2)

        val question3 = Questions(3,
            "which country's flag is this?",
            "Brazil" ,
            "Spain",
            "Australia",
            "Argentina",
            1,
            image = R.drawable.ic_flag_of_brazil)
        questionsList.add(question3)

        val question4 = Questions(4,
            "which country's flag is this?",
            "Nigeria",
            "Spain",
            "Australia",
            "Belgium",
            4,
            image = R.drawable.ic_flag_of_belgium)
        questionsList.add(question4)

        val question5 = Questions(5,
            "which country's flag is this?",
            "Iraq",
            "Iran",
            "Australia",
            "India",
            4,
            image = R.drawable.ic_flag_of_india)
        questionsList.add(question5)

        val question6 = Questions(6,
            "which country's flag is this?",
            "Iraq",
            "Iran",
            "Denmark",
            "India",
            3,
            image = R.drawable.ic_flag_of_denmark)
        questionsList.add(question6)

        val question7 = Questions(7,
            "which country's flag is this?",
            "England",
            "New zealand",
            "Wales",
            "India",
            2,
            image = R.drawable.ic_flag_of_new_zealand)
        questionsList.add(question7)

        val question8 = Questions(8,
            "which country's flag is this?",
            "Iraq",
            "Iran",
            "Kuwait",
            "India",
            3,
            image = R.drawable.ic_flag_of_kuwait)
        questionsList.add(question8)

        val question9 = Questions(9,
            "which country's flag is this?",
            "Fiji",
            "Iran",
            "Iraq",
            "Syria",
            1,
            image = R.drawable.ic_flag_of_fiji)
        questionsList.add(question9)

        val question10 = Questions(10,
            "which country's flag is this?",
            "Iraq",
            "Iran",
            "Germany",
            "India",
            3,
            image = R.drawable.ic_flag_of_germany)
        questionsList.add(question10)

        val question11 = Questions(11,
            "which country's flag is this?",
            "Nigeria" ,
            "Spain",
            "Australia",
            "Argentina",
            4,
            image = R.drawable.ic_flag_of_argentina)
        questionsList.add(question11)

        return questionsList
    }
}

