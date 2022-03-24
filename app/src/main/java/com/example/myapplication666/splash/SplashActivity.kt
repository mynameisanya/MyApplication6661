package com.example.myapplication666.splash

import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication666.R
import com.example.myapplication666.errors.NoAuthException

class SplashActivity : BaseActivity() {
    override val startForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            when (result.resultCode) {
                RESULT_OK -> renderData()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash)    //связывает класс и разметку
        val viewModel = ViewModelProvider(this).get(SplashViewModel::class.java) //инициализация вью модели

        viewModel.requestUser() //вью модель запрашивает юзера

        viewModel.viewState.observe(this@SplashActivity) //наблюдатель за тем, что пришло (ошибка или юзер)
        {
            when (it)
            {
                is SplashViewState.Error -> renderError(NoAuthException())
                SplashViewState.Success -> renderData()
            }
        }
    }
}