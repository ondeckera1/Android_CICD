package com.example.studentprofileapp.model

import androidx.annotation.DrawableRes

data class Student(
    val id: Int,
    val name: String,
    val major: String,
    val bio: String,

    @DrawableRes
    val imageRes: Int
)