package com.djnoddyp.irontracker

class WorkoutService(val repository: WorkoutRepository) {

    fun findAll() = repository.findAll()

    fun save(workout: Workout) = repository.save(workout)

}