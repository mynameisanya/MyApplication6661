package com.example.myapplication666

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication666.errors.NoAuthException
import com.example.myapplication666.splash.SplashViewState
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.launch

class MainViewModel : ViewModel()
    {
        val currentUserLiveData = MutableLiveData <FirebaseUser>()
        private val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
        private val currentUser
            get() = firebaseAuth.currentUser

        init {
            currentUserLiveData.value = currentUser
        }

    }