package com.example.quizetooapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ScoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score)

        val scoreTextView = findViewById<TextView>(R.id.score_Text)
        val feedbackTextView = findViewById<TextView>(R.id.feedback_text)
        val reviewTextView = findViewById<TextView>(R.id.review_text)
        val reviewButton = findViewById<Button>(R.id.btn_review)
        val exitButton = findViewById<Button>(R.id.btn_exit)

        // Retrieve the score passed from the previous activity (FlashCardActivity).
        // The second argument (0) is the default value if no score was passed.
        val score = intent.getIntExtra("score", 0)

        // Set the text of the scoreTextView to display the user's score out of the total number of questions (5).
        scoreTextView.text = "Your Score: $score / 5"

        // Set the text of the feedbackTextView based on the user's score.
        // If the score is 3 or higher, display "Great job!", otherwise display "Keep practicing!".
        feedbackTextView.text = if (score >= 3) "Great job!" else "Keep practicing!"

        // Set an OnClickListener for the review button. This code will execute when the review button is clicked.
        reviewButton.setOnClickListener {
            // For now, simply display a message indicating that the review functionality is not yet implemented.
            reviewTextView.text = "Review not implemented yet."
        }

        // Set an OnClickListener for the exit button. This code will execute when the exit button is clicked.
        exitButton.setOnClickListener {
            // Call finishAffinity() to close the current activity and all activities that belong to the same task.
            // This effectively exits the entire app.
            finishAffinity()
        }
        // Title: IIE module manual
        // Author:IMAD5112
        // Date:17  May 2025
        // Version:1.0
        // Available:https://advtechonline.sharepoint.com/:w:/r/sites/TertiaryStudents/_layouts/15/Doc.aspx?sourcedoc=%7BA1FF62F0-8E1A-47BC-99BD-CA07AE24427D%7D&file=IMAD5112_MM.docx&action=default&mobileredirect=true
        }

}
