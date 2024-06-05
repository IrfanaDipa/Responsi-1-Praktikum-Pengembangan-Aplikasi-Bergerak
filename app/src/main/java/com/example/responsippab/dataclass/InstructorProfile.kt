package com.example.responsippab.dataclass

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class InstructorProfile(
    val instructorPhoto: Int,
    val instructorName: String,
    val instructorDetail: String
):Parcelable
