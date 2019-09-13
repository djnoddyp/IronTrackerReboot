package com.djnoddyp.irontracker

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController("/workouts")
class WorkoutController(val service: WorkoutService) {

    @GetMapping
    fun findAll() = service.findAll()

    @PostMapping
    fun save(@RequestBody workout: Workout) = service.save(workout)

}