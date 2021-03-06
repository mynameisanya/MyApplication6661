package com.example.myapplication666.splash

import androidx.constraintlayout.motion.utils.ViewState
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication666.errors.NoAuthException
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel() {
    val viewState = MutableLiveData<SplashViewState>()
    private val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    private val currentUser
        get() = firebaseAuth.currentUser

    fun requestUser() {
        viewModelScope.launch(Dispatchers.IO) {
            delay(3000)
            viewState.postValue(currentUser?.let { SplashViewState.Success }
                ?: SplashViewState.Error(
                    NoAuthException()
                ))
        }
    }
}