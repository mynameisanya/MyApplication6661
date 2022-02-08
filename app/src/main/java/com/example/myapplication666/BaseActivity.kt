package com.example.myapplication666

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.core.content.ContextCompat
import com.example.myapplication666.errors.NoAuthException
import com.firebase.ui.auth.AuthUI
import com.google.android.material.snackbar.Snackbar

 abstract class BaseActivity : AppCompatActivity() {
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

     protected open fun renderError(error:Throwable)
     {
        when (error)
        {
            is NoAuthException -> startLoginActivity()
            else -> error.message?.let { Toast.makeText(applicationContext, "Exception is happen", Toast.LENGTH_SHORT).show() }

        }
     }

}