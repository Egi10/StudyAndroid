package com.example.studyandroid

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Food(
    val image: String,
    val text: String
): Parcelable
