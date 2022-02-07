package br.com.lucas.receitaapp.data.network.model

import java.lang.Exception

sealed class ResultApi<out R> {
    data class Success<out T>(val data: T?) : ResultApi<T?>()
    data class Error(val exception: Exception) : ResultApi<Nothing>()
}