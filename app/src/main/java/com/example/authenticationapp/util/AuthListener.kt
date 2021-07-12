package com.example.authenticationapp.util

interface AuthListener {

    fun onStarted()
    fun onSuccess()
    fun onFailure(message : String)
}