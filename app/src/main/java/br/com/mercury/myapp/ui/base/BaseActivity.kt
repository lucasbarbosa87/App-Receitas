package br.com.mercury.myapp.ui.base

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

abstract class BaseActivity : ComponentActivity() {

    abstract var isCompose: Boolean
    abstract var layoutRes: Int?

    override fun onCreate(savedInstanceState: Bundle?) {
        if (!isCompose) {
            setContentView(layoutRes!!)
        }
        super.onCreate(savedInstanceState)

        initialize()
    }

    abstract fun initialize()

}