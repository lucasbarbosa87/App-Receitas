package br.com.lucas.receitaapp.data.network

import br.com.lucas.receitaapp.data.network.model.RecipeModelResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {

    @GET("/api/v2/recipe/top/recipes")
    suspend fun topRecipe(
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 10
    ): Response<List<RecipeModelResponse>>

}