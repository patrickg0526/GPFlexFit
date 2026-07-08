package com.example.flexfit

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

// Patrick Gonzalez - SDC 340 Course Project - FlexFit
// MainActivity: Home / Setup screen - choose focus area + duration, then generate a workout
class MainActivity : AppCompatActivity() {

    private var selectedFocus: String? = null
    private var selectedDuration: String? = null

    private lateinit var focusButtons: List<Button>
    private lateinit var durationButtons: List<Button>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnFullBody = findViewById<Button>(R.id.btnFullBody)
        val btnUpperBody = findViewById<Button>(R.id.btnUpperBody)
        val btnLowerBody = findViewById<Button>(R.id.btnLowerBody)
        val btnCore = findViewById<Button>(R.id.btnCore)
        focusButtons = listOf(btnFullBody, btnUpperBody, btnLowerBody, btnCore)

        val btn5Min = findViewById<Button>(R.id.btn5Min)
        val btn10Min = findViewById<Button>(R.id.btn10Min)
        val btn15Min = findViewById<Button>(R.id.btn15Min)
        durationButtons = listOf(btn5Min, btn10Min, btn15Min)

        val btnGenerate = findViewById<Button>(R.id.btnGenerate)

        val focusMap = mapOf(
            btnFullBody to "Full Body",
            btnUpperBody to "Upper Body",
            btnLowerBody to "Lower Body",
            btnCore to "Core"
        )
        val durationMap = mapOf(
            btn5Min to "5 Minutes",
            btn10Min to "10 Minutes",
            btn15Min to "15 Minutes"
        )

        for (button in focusButtons) {
            button.setOnClickListener {
                selectedFocus = focusMap[button]
                for (b in focusButtons) {
                    val selected = b == button
                    b.backgroundTintList = ContextCompat.getColorStateList(
                        this, if (selected) R.color.purple_primary else R.color.purple_light
                    )
                    b.setTextColor(
                        ContextCompat.getColor(this, if (selected) R.color.white else R.color.text_dark)
                    )
                }
            }
        }

        for (button in durationButtons) {
            button.setOnClickListener {
                selectedDuration = durationMap[button]
                for (b in durationButtons) {
                    val selected = b == button
                    b.backgroundTintList = ContextCompat.getColorStateList(
                        this, if (selected) R.color.purple_primary else R.color.purple_light
                    )
                    b.setTextColor(
                        ContextCompat.getColor(this, if (selected) R.color.white else R.color.text_dark)
                    )
                }
            }
        }

        btnGenerate.setOnClickListener {
            val focus = selectedFocus
            val duration = selectedDuration
            if (focus == null) {
                Toast.makeText(this, "Please choose a focus area", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (duration == null) {
                Toast.makeText(this, "Please choose a workout duration", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val exercises = WorkoutData.generateWorkout(focus, duration)
            val intent = Intent(this, WorkoutListActivity::class.java)
            intent.putStringArrayListExtra("exercises", exercises)
            intent.putExtra("focusArea", focus)
            intent.putExtra("duration", duration)
            startActivity(intent)
        }
    }
}
