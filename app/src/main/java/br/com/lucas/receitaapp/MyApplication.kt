package br.com.lucas.receitaapp

import android.app.Application
import br.com.lucas.receitaapp.di.appModules
import br.com.lucas.receitaapp.utils.initializeStetho
import br.com.mercury.myapp.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            initializeStetho(this)
        }

        startKoin {
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(this@MyApplication)
            modules(appModules)
        }
    }

}