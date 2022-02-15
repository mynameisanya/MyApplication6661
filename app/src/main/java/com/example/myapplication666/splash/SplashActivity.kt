package com.example.myapplication666.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication666.BaseActivity
import com.example.myapplication666.R
import com.example.myapplication666.errors.NoAuthException
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : BaseActivity() {
    override val startForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            when (result.resultCode) {
                RESULT_OK -> renderData()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val viewModel = ViewModelProvider(this).get(SplashViewModel::class.java)

        viewModel.requestUser()

        viewModel.viewState.observe(this@SplashActivity)
        {
            when (it)
            {
                is SplashViewState.Error -> renderError(NoAuthException())
                SplashViewState.Success -> renderData()
            }
        }
    }
}