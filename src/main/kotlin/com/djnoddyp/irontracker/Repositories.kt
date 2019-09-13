package com.djnoddyp.irontracker

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

interface WorkoutRepository : JpaRepository<Workout, Long> {
    fun findAllByDateTime()
}

interface ExerciseRepository : CrudRepository<Exercise, Long> {
    fun findAllById()
}