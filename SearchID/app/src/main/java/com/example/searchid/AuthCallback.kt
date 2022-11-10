package com.example.searchid

interface AuthCallback {
    fun onLogin(username: String, password: String)
}