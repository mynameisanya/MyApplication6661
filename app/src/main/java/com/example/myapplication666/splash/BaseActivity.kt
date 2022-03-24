package com.example.myapplication666.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import com.example.myapplication666.MainActivity
import com.example.myapplication666.R
import com.example.myapplication666.errors.NoAuthException
import com.firebase.ui.auth.AuthUI

abstract class BaseActivity : AppCompatActivity() {
     //отрисовка элементов логина и пароля
    private fun startLoginActivity()
    {
        val provider = listOf(AuthUI.IdpConfig.EmailBuilder().build())
        startForResult.launch(AuthUI.getInstance()
            .createSignInIntentBuilder()
            .setLogo(R.drawable.ic_launcher_background)
            .setTheme(R.style.Theme_MyApplication666)
            .setAvailableProviders(provider)
            .build()
        )
    }

     protected abstract val startForResult: ActivityResultLauncher<Intent>

     //если юзер вошел, то поадаем в главное меню
     protected fun renderData()
     {
         startMainActivity()
     }

     private fun startMainActivity()
     {
         val intent = Intent(this, MainActivity::class.java)
         startActivity(intent)
         finish()
     }
    //метод для обработки ошибок, возвращает обратно к логину
     protected open fun renderError(error:Throwable)
     {
        when (error)
        {
            is NoAuthException -> startLoginActivity()
            else -> error.message?.let { Toast.makeText(applicationContext, "Exception is happen", Toast.LENGTH_SHORT).show() }

        }
     }

}