package br.com.mercury.myapp.ui.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import br.com.mercury.myapp.ui.base.BaseActivity
import br.com.mercury.myapp.ui.login.LoginActivity
import dagger.hilt.android.AndroidEntryPoint

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashScreenActivity : BaseActivity() {

    private val viewModel: SplashScreenViewModel by viewModels()

    override var isCompose: Boolean = true
    override var layoutRes: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        setContent {
            SplashScreenView()
        }
        super.onCreate(savedInstanceState)
    }

    override fun initialize() {
        viewModel.initialize {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}



