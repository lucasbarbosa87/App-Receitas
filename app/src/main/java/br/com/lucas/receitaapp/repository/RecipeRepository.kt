package br.com.lucas.receitaapp.repository

import androidx.lifecycle.LiveData
import br.com.lucas.receitaapp.data.local.model.RecipeTopDisplay
import br.com.lucas.receitaapp.data.network.model.ResultApi

interface RecipeRepository {

    fun fetchTopRecipes(): LiveData<ResultApi<List<RecipeTopDisplay>?>>

}