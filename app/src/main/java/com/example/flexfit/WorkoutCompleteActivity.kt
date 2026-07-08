package com.example.flexfit

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

// Patrick Gonzalez - SDC 340 Course Project - FlexFit
// WorkoutCompleteActivity: shown after finishing a workout, with a summary and next steps
class WorkoutCompleteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout_complete)

        val duration = intent.getStringExtra("duration") ?: "10 Minutes"
        val exerciseCount = intent.getIntExtra("exerciseCount", 0)

        val txtDuration = findViewById<TextView>(R.id.txtDuration)
        val txtExerciseCount = findViewById<TextView>(R.id.txtExerciseCount)
        txtDuration.text = "Duration: $duration"
        txtExerciseCount.text = "Exercises: $exerciseCount"

        val btnGenerateAnother = findViewById<Button>(R.id.btnGenerateAnother)
        val btnSaveWorkout = findViewById<Button>(R.id.btnSaveWorkout)
        val btnGoHome = findViewById<Button>(R.id.btnGoHome)

        btnGenerateAnother.setOnClickListener {
            val homeIntent = Intent(this, MainActivity::class.java)
            homeIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(homeIntent)
            finish()
        }

        btnSaveWorkout.setOnClickListener {
            Toast.makeText(this, "Workout saved!", Toast.LENGTH_SHORT).show()
        }

        btnGoHome.setOnClickListener {
            val homeIntent = Intent(this, MainActivity::class.java)
            homeIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(homeIntent)
            finish()
        }
    }
}
