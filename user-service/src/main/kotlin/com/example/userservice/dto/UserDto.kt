package com.example.userservice.dto

import java.util.*

data class UserDto(
    var email: String= "",
    var name: String = "",
    var pwd: String= "",

    var userId: String = "",
    var createdAt: Date = Date(),
    var encryptedPwd: String = "",
)