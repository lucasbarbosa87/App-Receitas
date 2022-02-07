package br.com.lucas.receitaapp.ui.login

import android.os.Bundle
import androidx.activity.compose.setContent
import br.com.lucas.receitaapp.ui.base.BaseActivity
import br.com.lucas.receitaapp.ui.login.compose.LoginView

class LoginActivity : BaseActivity() {
    override var isCompose: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        setContent {
            LoginView(context = this)
        }

        super.onCreate(savedInstanceState)
    }

    override fun initialize() {
    }

    override fun binding() {
    }


}