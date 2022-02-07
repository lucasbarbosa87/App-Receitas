package br.com.lucas.receitaapp.ui.main

import android.view.MenuItem
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import br.com.mercury.myapp.databinding.MainActivityBinding
import br.com.lucas.receitaapp.ui.base.BaseActivity

class MainActivity : BaseActivity() {

    override var isCompose: Boolean = false
    lateinit var binding: MainActivityBinding

    override fun binding() {
        binding = MainActivityBinding.inflate(layoutInflater)
        this.layout = binding.root
    }

    override fun initialize() {
        val fragment =
            supportFragmentManager.findFragmentById(binding.fragmentMain.id) as NavHostFragment
        binding.bottomNavigationView.setupWithNavController(fragment.navController)
        setupActionBarWithNavController(this, fragment.navController)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            else -> super.onOptionsItemSelected(item)
        }
    }
}