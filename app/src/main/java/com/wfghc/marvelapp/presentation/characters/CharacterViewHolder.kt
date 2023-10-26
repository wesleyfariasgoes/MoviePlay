package com.wfghc.marvelapp.presentation.characters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wfghc.core.domain.model.Character
import com.wfghc.marvelapp.R
import com.wfghc.marvelapp.databinding.ItemCharacterBinding

class CharacterViewHolder(
    itemCharacterBinding: ItemCharacterBinding
): RecyclerView.ViewHolder(itemCharacterBinding.root) {

    private val textName = itemCharacterBinding.textName
    private val imageCharacter = itemCharacterBinding.imageCharacter

    fun bind(charater: Character) {
        textName.text = charater.name
        Glide.with(itemView)
            .load(charater.imageUrl)
            .fallback(R.drawable.ic_img_loading_error)
            .into(imageCharacter)
    }

    companion object {
        fun create(parent: ViewGroup): CharacterViewHolder {
            val inflate = LayoutInflater.from(parent.context)
            val intemBind = ItemCharacterBinding.inflate(inflate,parent,false)
            return CharacterViewHolder(intemBind)
        }
    }
}