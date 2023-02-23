package com.example.satri.ui.main

import android.os.Bundle
import android.view.View
import com.example.satri.databinding.FragmentMainBinding
import com.example.satri.utils.ViewBindingFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class FragmentMain : ViewBindingFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {

    companion object {
        fun newInstance() = FragmentMain()
    }

    private val viewModel: MainViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}