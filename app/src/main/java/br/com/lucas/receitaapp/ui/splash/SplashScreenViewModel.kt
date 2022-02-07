package br.com.lucas.receitaapp.ui.splash

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenViewModel(
    application: Application
) : AndroidViewModel(application) {

    fun initialize(
        finish: (finished: Boolean) -> Unit
    ) {
        viewModelScope.launch {
            delay(1000)
            finish(true)
        }
    }


}