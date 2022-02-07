package br.com.lucas.receitaapp.data.local.model

import br.com.lucas.receitaapp.data.network.model.RecipeModelResponse

data class RecipeTopDisplay(
    val name: String,
    val image: String
) {
    constructor(recipeResponse: RecipeModelResponse) : this(
        name = recipeResponse.name!!,
        image = recipeResponse.image!!
    )
}