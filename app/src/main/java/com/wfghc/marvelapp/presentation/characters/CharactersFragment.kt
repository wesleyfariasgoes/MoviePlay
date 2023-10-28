package com.wfghc.marvelapp.presentation.characters

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wfghc.core.domain.model.Character
import com.wfghc.marvelapp.R
import com.wfghc.marvelapp.databinding.FragmentCharactersBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


@AndroidEntryPoint
class CharactersFragment : Fragment() {

    private var _binding: FragmentCharactersBinding? = null
    private val binding: FragmentCharactersBinding get() = _binding!!

    private val viewModel: CharactersViewModel by viewModels()

    private val charaptersAdapter = CharactersAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentCharactersBinding.inflate(
        inflater,
        container,
        false
    ).apply {
        _binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initCharacterAdapter()

        lifecycleScope.launch {
            viewModel.charactersPagingData("").collect { paginData ->
                charaptersAdapter.submitData(paginData)

            }
        }
    }

    @Suppress("MagicNumber")
    private fun initCharacterAdapter() {
        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager( requireContext(), 2)
        binding.recyclerCharacters.layoutManager = layoutManager
        with(binding.recyclerCharacters) {
            setHasFixedSize(true)
            adapter= charaptersAdapter
        }
    }

}