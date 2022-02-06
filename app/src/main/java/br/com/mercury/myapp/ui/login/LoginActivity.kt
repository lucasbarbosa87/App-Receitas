package br.com.mercury.myapp.ui.login

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import br.com.mercury.myapp.ui.base.BaseActivity
import br.com.mercury.myapp.ui.login.compose.LoginView

class LoginActivity : BaseActivity() {
    override var isCompose: Boolean = true
    override var layoutRes: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        setContent {
            LoginView(context = this)
        }

        super.onCreate(savedInstanceState)
    }

    override fun initialize() {
    }


}