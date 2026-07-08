package com.example.flexfit

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

// Patrick Gonzalez - SDC 340 Course Project - FlexFit
// ActiveWorkoutActivity: steps through one exercise at a time with Previous/Next/Skip
class ActiveWorkoutActivity : AppCompatActivity() {

    private var exercises: ArrayList<String> = ArrayList()
    private var currentIndex = 0
    private lateinit var duration: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_active_workout)

        exercises = intent.getStringArrayListExtra("exercises") ?: ArrayList()
        duration = intent.getStringExtra("duration") ?: "10 Minutes"

        val txtProgress = findViewById<TextView>(R.id.txtProgress)
        val txtExerciseName = findViewById<TextView>(R.id.txtExerciseName)
        val btnPrevious = findViewById<Button>(R.id.btnPrevious)
        val btnSkip = findViewById<Button>(R.id.btnSkip)
        val btnNext = findViewById<Button>(R.id.btnNext)

        fun updateUi() {
            txtProgress.text = "Exercise ${currentIndex + 1} of ${exercises.size}"
            txtExerciseName.text = if (exercises.isNotEmpty()) exercises[currentIndex] else "No exercises"
            btnPrevious.isEnabled = currentIndex > 0
        }

        fun goToNext() {
            if (currentIndex < exercises.size - 1) {
                currentIndex++
                updateUi()
            } else {
                val completeIntent = Intent(this, WorkoutCompleteActivity::class.java)
                completeIntent.putExtra("duration", duration)
                completeIntent.putExtra("exerciseCount", exercises.size)
                startActivity(completeIntent)
                finish()
            }
        }

        btnPrevious.setOnClickListener {
            if (currentIndex > 0) {
                currentIndex--
                updateUi()
            }
        }

        btnNext.setOnClickListener { goToNext() }
        btnSkip.setOnClickListener { goToNext() }

        updateUi()
    }
}
