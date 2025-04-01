package com.example.translatorapp.view

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.example.translatorapp.model.models.CharacterResponse
import com.example.translatorapp.viewmodel.CharacterViewModel

import com.example.weatherapp.databinding.FragmentItemBinding


class CharacterAdapter(private val onCharacterClick: (CharacterResponse.Result) -> Unit)  : ListAdapter<CharacterResponse.Result, CharacterAdapter.CharacterViewHolder>(DifUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(FragmentItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = getItem(position)
        with(holder){
            binding.characterTv.text = character.name
            Glide.with(binding.characterIv).load(character.image).into(binding.characterIv)

            itemView.setOnClickListener {
                onCharacterClick(character)
            }
        }





    }



    class DifUtil: DiffUtil.ItemCallback<CharacterResponse.Result>(){
        override fun areItemsTheSame(
            oldItem: CharacterResponse.Result,
            newItem: CharacterResponse.Result
        ): Boolean {
            return oldItem.id == newItem.id

        }

        override fun areContentsTheSame(
            oldItem: CharacterResponse.Result,
            newItem: CharacterResponse.Result
        ): Boolean {

            return oldItem == newItem

        }



    }
    class CharacterViewHolder ( val binding: FragmentItemBinding):RecyclerView.ViewHolder(binding.root)



}