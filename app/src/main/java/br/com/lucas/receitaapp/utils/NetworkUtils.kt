package br.com.lucas.receitaapp.utils

import android.content.Context
import com.facebook.stetho.Stetho
import com.google.gson.GsonBuilder
import retrofit2.converter.gson.GsonConverterFactory


internal fun getJsonConverter(): GsonConverterFactory {
    val gsonFactory = GsonBuilder().setLenient().serializeNulls().create()
    return GsonConverterFactory.create(gsonFactory)
}

fun initializeStetho(context: Context) {
    Stetho.initializeWithDefaults(context)
}