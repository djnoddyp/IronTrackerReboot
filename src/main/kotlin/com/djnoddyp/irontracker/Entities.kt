package com.djnoddyp.irontracker

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType.SEQUENCE
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
class Workout(@Id @GeneratedValue(strategy = SEQUENCE) val id: Long,
              val dateTime: LocalDateTime = LocalDateTime.now(),
              @OneToMany val exercises: List<Exercise>)

@Entity
class Exercise(@Id @GeneratedValue(strategy = SEQUENCE) val id: Long,
               val name: String,
               val sets: Int,
               val reps: Int,
               val weight: Double?)