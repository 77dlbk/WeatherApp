package com.example.translatorapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.translatorapp.model.models.CharacterResponse
import com.example.weatherapp.R
import com.example.weatherapp.databinding.FragmentCharacterDetailBinding


@Suppress("UNREACHABLE_CODE")
class CharacterDetailFragment : Fragment() {

    private lateinit var binding: FragmentCharacterDetailBinding




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharacterDetailBinding.inflate(inflater,container,false)

        val character = arguments?.getParcelable<CharacterResponse.Result>("character")

        character?.let {
            binding.characterName.text = it.name
            binding.characterStatus.text = it.status
            binding.characterSpecies.text = it.species
            binding.characterGender.text = it.gender
            Glide.with(binding.characterImage).load(it.image).into(binding.characterImage)
        }

        return binding.root
    }
    companion object {
        fun newInstance(character: CharacterResponse.Result): CharacterDetailFragment {
            val fragment = CharacterDetailFragment()
            val args = Bundle()
            args.putParcelable("character", character)
            fragment.arguments = args
            return fragment
        }
    }


}