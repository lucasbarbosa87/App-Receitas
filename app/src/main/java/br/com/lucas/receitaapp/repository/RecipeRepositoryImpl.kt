package br.com.lucas.receitaapp.repository

import androidx.lifecycle.liveData
import br.com.lucas.receitaapp.data.local.model.RecipeTopDisplay
import br.com.lucas.receitaapp.data.network.ApiClient
import br.com.lucas.receitaapp.data.network.model.ResultApi

class RecipeRepositoryImpl(private val client: ApiClient) : RecipeRepository {

    override fun fetchTopRecipes() = liveData {
        try {
            val response = client.topRecipe()
            if (response.isSuccessful) {
                val body = response.body()
                emit(ResultApi.Success(body!!.map { RecipeTopDisplay(it) }))
            } else {
                emit(ResultApi.Error(exception = Exception(response.errorBody().toString())))
            }
        } catch (e: Exception) {
            emit(ResultApi.Error(exception = e))
        }
    }

}