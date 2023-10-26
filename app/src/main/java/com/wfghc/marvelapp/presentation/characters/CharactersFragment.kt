package com.wfghc.marvelapp.presentation.characters

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wfghc.core.domain.model.Character
import com.wfghc.marvelapp.R
import com.wfghc.marvelapp.databinding.FragmentCharactersBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CharactersFragment : Fragment() {

    private var _binding: FragmentCharactersBinding? = null
    private val binding: FragmentCharactersBinding get() = _binding!!

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
        charaptersAdapter.submitList(
            listOf(
                Character("3D-Man","https://cdn.marvel.com/u/prod/marvel/i/mg/c/10/5a612c90dfdb5/portrait_uncanny.jpg"),
                Character("3D-Man","https://cdn.marvel.com/u/prod/marvel/i/mg/c/10/5a612c90dfdb5/portrait_uncanny.jpg"),
                Character("3D-Man","https://cdn.marvel.com/u/prod/marvel/i/mg/c/10/5a612c90dfdb5/portrait_uncanny.jpg"),
                Character("3D-Man","https://cdn.marvel.com/u/prod/marvel/i/mg/c/10/5a612c90dfdb5/portrait_uncanny.jpg"),
                Character("3D-Man","https://cdn.marvel.com/u/prod/marvel/i/mg/c/10/5a612c90dfdb5/portrait_uncanny.jpg"),
                Character("3D-Man","https://cdn.marvel.com/u/prod/marvel/i/mg/c/10/5a612c90dfdb5/portrait_uncanny.jpg"),
                Character("3D-Man","https://cdn.marvel.com/u/prod/marvel/i/mg/c/10/5a612c90dfdb5/portrait_uncanny.jpg"),
                Character(
                    "3D-Man",
                    "https://cdn.marvel.com/u/prod/marvel/i/mg/c/10/5a612c90dfdb5/portrait_uncanny.jpg"
                ),
                Character(
                    "3D-Man",
                    "https://cdn.marvel.com/u/prod/marvel/i/mg/c/10/5a612c90dfdb5/portrait_uncanny.jpg"
                ),
                Character(
                    "3D-Man",
                    "https://cdn.marvel.com/u/prod/marvel/i/mg/c/10/5a612c90dfdb5/portrait_uncanny.jpg"
                ),
                Character(
                    "3D-Man",
                    "https://cdn.marvel.com/u/prod/marvel/i/mg/c/10/5a612c90dfdb5/portrait_uncanny.jpg"
                ),
                Character(
                    "3D-Man",
                    "https://cdn.marvel.com/u/prod/marvel/i/mg/c/10/5a612c90dfdb5/portrait_uncanny.jpg"
                )
            )
        )
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