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
    //аутентификация firebase
    val viewState = MutableLiveData<SplashViewState>()
    private val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    private val currentUser
        get() = firebaseAuth.currentUser


    fun requestUser() {
        viewModelScope.launch(Dispatchers.IO) //переход на новый поток IO
        {
            delay(3000) //ожидание
            viewState.postValue(currentUser?.let { SplashViewState.Success } //обращаемся к юзеру
                ?: SplashViewState.Error( //если ошибка
                    NoAuthException()
                ))
        }
    }
}