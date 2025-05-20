package com.example.quizetooapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FlashCardActivity : AppCompatActivity() {
    // Array of strings to hold the questions for the flashcards
    private val questions = arrayOf(
        "Nelson Mandela was the president in 1994",
        "World War II ended in 1945",
        "The Berlin Wall fell in 1989",
        "The Roman Empire fell in 476",
        "The Declaration of Independence was signed in 1776"
    )
    // Boolean array corresponding to the questions, holding the correct answer (true or false) for each question
    private val answers = booleanArrayOf(true, true, true, true, true)

    // Declare variables for the TextView that will display the question
    private lateinit var questionText: TextView
    // Declare a variable for the TextView that will display feedback to the user (e.g., "Correct!" or "Incorrect")
    private lateinit var feedbackText: TextView
    // Declare variables for the buttons that the user will click to answer true or false
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button

    // Variable to keep track of the current question index
    private var index = 0
    // Variable to keep track of the user's score
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_flash_card)


        questionText = findViewById(R.id.question_text)
        feedbackText = findViewById(R.id.feedback_text)
        trueButton = findViewById(R.id.btn_true)
        falseButton = findViewById(R.id.btn_false)
         val nextButton = findViewById<Button>(R.id.btn_next)

        // Call the showQuestion function to display the first question
        showQuestion()

        // Set an OnClickListener for the true button. This code will execute when the true button is clicked.
        trueButton.setOnClickListener {
            // Call the checkAnswer function with 'true' as the user's answer
            checkAnswer(true)
        }

        // Set an OnClickListener for the false button. This code will execute when the false button is clicked.
        falseButton.setOnClickListener {
            // Call the checkAnswer function with 'false' as the user's answer
            checkAnswer(false)
        }

        // Set an OnClickListener for the next button. This code will execute when the next button is clicked.
        nextButton.setOnClickListener {
            // Call the nextQuestion function to move to the next question or finish the quiz
            nextQuestion()
        }
    }
    // Function to display the current question
    private fun showQuestion() {
        questionText.text = questions[index]
        feedbackText.text = ""
        trueButton.isEnabled = true
        falseButton.isEnabled = true
    }

    // Function to check if the user's answer is correct
    private fun checkAnswer(userAnswer: Boolean) {
        if (userAnswer == answers[index]) {
            feedbackText.text = "Correct!"
            score++
        } else {
            feedbackText.text = "Incorrect"
        }

        trueButton.isEnabled = false
        falseButton.isEnabled = false
    }

    // Function to move to the next question or finish the quiz
    private fun nextQuestion() {
        index++
        if (index < questions.size) {
            showQuestion()
        } else {
            val intent = Intent(this, ScoreActivity::class.java)
            intent.putExtra("score", score)
            startActivity(intent)
            // Finish the current FlashCardActivity so the user cannot go back to the quiz
            finish()
            }


    } }          // Title: IIE module manual
                 // Author:IMAD5112
                // Date:17  May 2025
               // Version:1.0
              // Available:https://advtechonline.sharepoint.com/:w:/r/sites/TertiaryStudents/_layouts/15/Doc.aspx?sourcedoc=%7BA1FF62F0-8E1A-47BC-99BD-CA07AE24427D%7D&file=IMAD5112_MM.docx&action=default&mobileredirect=true




