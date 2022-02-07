package br.com.lucas.receitaapp.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.lucas.receitaapp.data.network.model.ResultApi
import br.com.lucas.receitaapp.ui.base.BaseFragment
import br.com.mercury.myapp.databinding.FragmentHomeBinding
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment() {

    private val viewModel: HomeViewModel by viewModel()

    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        initialize()
        return binding.root
    }

    override fun initialize() {
        viewModel.fetchRecipes().observe(viewLifecycleOwner) {

            when (it) {
                is ResultApi.Success -> {
                    Log.d("teste", it.data.toString())
                }
                is ResultApi.Error -> {
                    Log.d("teste", it.exception.toString())
                    Snackbar.make(
                        binding.root,
                        it.exception.message.toString(),
                        Snackbar.LENGTH_LONG
                    ).show()
                }
            }

        }
    }
}