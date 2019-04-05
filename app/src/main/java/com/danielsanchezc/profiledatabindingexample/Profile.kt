package com.danielsanchezc.profiledatabindingexample

import java.util.*

data class Profile(
        val firstName: String,
        val middleName: String,
        val lastName: String,
        val bornDate: Date,
        val deathDate: Date?,
        val photoUrl: String?
)