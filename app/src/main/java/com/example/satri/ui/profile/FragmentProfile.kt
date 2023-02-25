package com.example.satri.ui.profile

import android.os.Bundle
import android.view.View
import com.example.satri.databinding.FragmentProfileBinding
import com.example.satri.utils.ViewBindingFragment

class FragmentProfile :
    ViewBindingFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {

    companion object {
        fun newInstance() = FragmentProfile()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}