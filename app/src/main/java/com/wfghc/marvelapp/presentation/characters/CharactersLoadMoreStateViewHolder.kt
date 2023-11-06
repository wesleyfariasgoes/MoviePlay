package com.wfghc.marvelapp.presentation.characters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import com.wfghc.marvelapp.databinding.ItemCharacterLoadMoreStateBinding

class CharactersLoadMoreStateViewHolder(
    binding: ItemCharacterLoadMoreStateBinding,
    retry: () -> Unit
) :RecyclerView.ViewHolder(binding.root) {

    private val binding = ItemCharacterLoadMoreStateBinding.bind(itemView)
    private val progressBarLoadingMore = binding.progressLoadingMore
    private val textTryAgainMessage = binding.textTryAgin.also {
        it.setOnClickListener {
            retry()
        }
    }

    fun binds(loadState: LoadState) {
        progressBarLoadingMore.isVisible = loadState is LoadState.Loading
        textTryAgainMessage.isVisible = loadState is LoadState.Error
    }

    companion object {
        fun create(parent: ViewGroup, retry: () -> Unit): CharactersLoadMoreStateViewHolder {
            val itemBinding = ItemCharacterLoadMoreStateBinding
                .inflate(LayoutInflater.from(parent.context), parent,false)
            return CharactersLoadMoreStateViewHolder(itemBinding, retry)
        }
    }
}