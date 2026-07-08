package com.example.flexfit

// Patrick Gonzalez - SDC 340 Course Project - FlexFit
// WorkoutData: exercise pools and workout generation logic shared by MainActivity and WorkoutListActivity
object WorkoutData {

    private val fullBodyExercises = listOf(
        "Jumping Jacks", "Bodyweight Squats", "Push-Ups", "Burpees",
        "Mountain Climbers", "Plank", "Walking Lunges", "High Knees",
        "Bear Crawl", "Star Jumps"
    )

    private val upperBodyExercises = listOf(
        "Push-Ups", "Tricep Dips", "Plank Shoulder Taps", "Diamond Push-Ups",
        "Pike Push-Ups", "Arm Circles", "Superman Hold", "Incline Push-Ups"
    )

    private val lowerBodyExercises = listOf(
        "Bodyweight Squats", "Walking Lunges", "Calf Raises", "Wall Sit",
        "Glute Bridges", "Jump Squats", "Side Lunges", "Step-Ups"
    )

    private val coreExercises = listOf(
        "Plank", "Sit-Ups", "Bicycle Crunches", "Russian Twists",
        "Leg Raises", "Mountain Climbers", "Side Plank", "Flutter Kicks"
    )

    fun generateWorkout(focusArea: String, duration: String): ArrayList<String> {
        val pool = when (focusArea) {
            "Full Body" -> fullBodyExercises
            "Upper Body" -> upperBodyExercises
            "Lower Body" -> lowerBodyExercises
            "Core" -> coreExercises
            else -> fullBodyExercises
        }

        val count = when (duration) {
            "5 Minutes" -> 4
            "10 Minutes" -> 6
            "15 Minutes" -> 8
            else -> 6
        }

        val shuffled = pool.shuffled()
        val size = if (count > shuffled.size) shuffled.size else count
        return ArrayList(shuffled.take(size))
    }
}
