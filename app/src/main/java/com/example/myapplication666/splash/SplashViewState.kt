package com.example.myapplication666.splash

sealed class SplashViewState
{
    class Error (throwable: Throwable): SplashViewState()
    object Success :SplashViewState()
}






