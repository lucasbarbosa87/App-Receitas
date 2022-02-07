package br.com.lucas.receitaapp.di

import br.com.lucas.receitaapp.data.network.ApiClient
import br.com.lucas.receitaapp.repository.RecipeRepository
import br.com.lucas.receitaapp.repository.RecipeRepositoryImpl
import br.com.lucas.receitaapp.ui.home.HomeViewModel
import br.com.lucas.receitaapp.ui.splash.SplashScreenViewModel
import br.com.lucas.receitaapp.utils.getJsonConverter
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit


val appModules = module {
    factory { provideOkHttpClient() }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl("https://app.aquelareceita.com.br")
            .addConverterFactory(getJsonConverter())
            .build()
    }
    single<ApiClient> { get<Retrofit>().create(ApiClient::class.java) }
    single<RecipeRepository> { RecipeRepositoryImpl(get()) }

    viewModel { HomeViewModel(androidApplication(), get()) }
    viewModel { SplashScreenViewModel(androidApplication()) }
}

internal fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient().newBuilder()
        .addNetworkInterceptor(StethoInterceptor())
        .build()
}