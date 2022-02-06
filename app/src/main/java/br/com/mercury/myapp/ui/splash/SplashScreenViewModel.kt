package br.com.mercury.myapp.ui.splash

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor(
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