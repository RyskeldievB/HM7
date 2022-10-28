package com.example.navcomponent

import android.icu.text.Transliterator
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.navcomponent.databinding.ItemCharacterBinding

class CharacterAdapter(
    private val list: ArrayList<Character>, private val onClick: (pos: Int) -> Unit
) : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(
            ItemCharacterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            (onClick(position))
        }
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
    inner class CharacterViewHolder(private var binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(character: Character) {
            binding.image.setImageResource(character.image)
            binding.name.text = character.name
        }
    }
}