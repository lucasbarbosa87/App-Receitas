package br.com.lucas.receitaapp.ui.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import br.com.lucas.receitaapp.ui.base.BaseActivity
import br.com.lucas.receitaapp.ui.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashScreenActivity : BaseActivity() {

    private val viewModel: SplashScreenViewModel by viewModels()

    override var isCompose: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        setContent {
            SplashScreenView()
        }
        super.onCreate(savedInstanceState)
    }

    override fun initialize() {
        viewModel.initialize {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    //Dont need Because of Compose
    override fun binding() {
    }
}



