package com.example.translatorapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.translatorapp.viewmodel.TranslateViewModel
import com.example.weatherapp.databinding.FragmentTranslatorBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TranslatorFragment : Fragment() {

    private lateinit var binding: FragmentTranslatorBinding
    private val viewModel: TranslateViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding  = FragmentTranslatorBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            btnTranslate.setOnClickListener{
                viewModel.translate(
                    etSrc.text.toString(),
                    "en",
                    "ru"
                )
                try {
                    viewModel.translateResponse.observe(viewLifecycleOwner){
                        etResult.text = it.first().translations?.first()?.text
                    }
                }
                catch (e:Exception){
                    println(e)
                }

            }



        }
    }


}