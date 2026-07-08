package com.example.flexfit

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

// Patrick Gonzalez - SDC 340 Course Project - FlexFit
// WorkoutListActivity: shows the generated workout, allows regenerating or starting it
class WorkoutListActivity : AppCompatActivity() {

    private lateinit var focusArea: String
    private lateinit var duration: String
    private var exercises: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout_list)

        focusArea = intent.getStringExtra("focusArea") ?: "Full Body"
        duration = intent.getStringExtra("duration") ?: "10 Minutes"
        exercises = intent.getStringArrayListExtra("exercises") ?: ArrayList()

        val txtWorkoutInfo = findViewById<TextView>(R.id.txtWorkoutInfo)
        txtWorkoutInfo.text = "$focusArea • $duration"

        populateExerciseList()

        val btnRegenerate = findViewById<Button>(R.id.btnRegenerate)
        btnRegenerate.setOnClickListener {
            exercises = WorkoutData.generateWorkout(focusArea, duration)
            populateExerciseList()
        }

        val btnStartWorkout = findViewById<Button>(R.id.btnStartWorkout)
        btnStartWorkout.setOnClickListener {
            val startIntent = Intent(this, ActiveWorkoutActivity::class.java)
            startIntent.putStringArrayListExtra("exercises", exercises)
            startIntent.putExtra("focusArea", focusArea)
            startIntent.putExtra("duration", duration)
            startActivity(startIntent)
        }
    }

    private fun populateExerciseList() {
        val llExerciseList = findViewById<LinearLayout>(R.id.llExerciseList)
        llExerciseList.removeAllViews()
        for ((index, exercise) in exercises.withIndex()) {
            val txt = TextView(this)
            txt.text = "${index + 1}. $exercise"
            txt.textSize = 17f
            txt.setTextColor(getColor(R.color.text_dark))
            txt.setPadding(8, 20, 8, 20)
            txt.gravity = Gravity.START
            llExerciseList.addView(txt)
        }
    }
}
