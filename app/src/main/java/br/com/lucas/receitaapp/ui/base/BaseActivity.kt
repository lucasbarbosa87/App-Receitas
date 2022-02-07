package br.com.lucas.receitaapp.ui.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    abstract var isCompose: Boolean
    var layout: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding()
        if (!isCompose) {
            setContentView(layout)
        }

        initialize()
    }

    abstract fun initialize()
    abstract fun binding()
}