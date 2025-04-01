package com.example.translatorapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.translatorapp.model.models.CharacterResponse
import com.example.weatherapp.R
import com.example.translatorapp.viewmodel.CharacterViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CharacterFragment : Fragment() {

    private var columnCount = 1
    private val viewModel:CharacterViewModel by viewModels()
    private var character= ArrayList<CharacterResponse.Result>()
    private var characterAdapter  = CharacterAdapter{ character->
        val detailFragment = CharacterDetailFragment.newInstance(character)
        parentFragmentManager.beginTransaction().
                replace(R.id.fragment_container, detailFragment).addToBackStack(null).commit()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        arguments?.let {
//            columnCount = it.getInt(ARG_COLUMN_COUNT)
//        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_item_list, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.list)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = characterAdapter

        viewModel.getCharacter()
        viewModel.character.observe(viewLifecycleOwner){result->
            characterAdapter.submitList(result.results)
        }

        viewModel.error.observe(viewLifecycleOwner ){error ->
            Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
        }
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }

                adapter = characterAdapter
            }
            }

        return view
    }


}