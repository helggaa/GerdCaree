package com.dicoding.gerdcaree

import java.util.Date

data class UserRegistration(
    val id: String,
    val fullName: String,
    val birthdate: Date,
    val gender: String,
    val weight: Number,
    val height: Number,
    val gerdFrequency: String,
    val gerdPeriod: String,
    val medicineList: String
    )