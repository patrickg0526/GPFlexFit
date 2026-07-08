# FlexFit

**Author:** Patrick Gonzalez

## Description

FlexFit is a no-equipment home workout generator built for the SDC 340 Course Project. Users choose a focus area and a workout duration, and the app generates a randomized bodyweight workout they can step through one exercise at a time.

## Features

- Home/Setup screen with 4 focus area choices (Full Body, Upper Body, Lower Body, Core) and 3 duration choices (5, 10, 15 Minutes)
- Randomized workout generation from exercise pools based on focus area and duration
- Generated Workout screen listing all exercises, with Regenerate and Start Workout options
- Active Workout screen that steps through exercises one at a time with progress tracking (Exercise X of N) and Previous/Next/Skip controls
- Workout Complete screen with a summary card (duration + exercise count) and options to generate another workout, save the workout, or return home
- Custom app icon and color scheme (purple primary, light purple secondary, green success accent)

## Activities

1. **MainActivity** - Home / Setup
2. **WorkoutListActivity** - Generated Workout
3. **ActiveWorkoutActivity** - Active Workout
4. **WorkoutCompleteActivity** - Workout Complete

## Tech

- Kotlin
- LinearLayout / ScrollView
- Android SDK (minSdk 24, targetSdk/compileSdk 36)
