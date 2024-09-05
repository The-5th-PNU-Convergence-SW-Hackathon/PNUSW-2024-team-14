package com.example.jasmin2.login

data class LoginResponse(
    val success: Boolean,
    val token: String?,
    val error: String?
)