package com.example.android4a.presentation.main

sealed class LoginStatus

data class LoginSucess(val email: String) : LoginStatus()
object LoginError : LoginStatus()

    