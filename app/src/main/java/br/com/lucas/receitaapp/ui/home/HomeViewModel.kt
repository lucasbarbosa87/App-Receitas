package br.com.lucas.receitaapp.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import br.com.lucas.receitaapp.repository.RecipeRepository

class HomeViewModel(
    application: Application,
    private val recipeRepository: RecipeRepository
) : AndroidViewModel(application) {


    fun fetchRecipes() = recipeRepository.fetchTopRecipes()
}