package com.example.satri.ui.login

import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.Toast
import com.example.satri.R
import com.example.satri.databinding.FragmentLoginBinding
import com.example.satri.ui.profile.FragmentProfile
import com.example.satri.utils.ViewBindingFragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.qualifier.named

class FragmentLogin : ViewBindingFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {

    companion object {
        fun newInstance() = FragmentLogin()
    }

    private val viewModel: LoginViewModels by viewModel(named("login_view_model"))

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        passwordText()
        startLogin()
    }

    private fun passwordText() {
        val text = binding.etPassword
        text.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD

        val visibilityPassword =
            InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
        val hiddenPassword = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD

        binding.btnVisibilityPass.setOnClickListener {
            if (text.inputType == hiddenPassword) {
                text.inputType = visibilityPassword
            } else {
                text.inputType = hiddenPassword
            }
        }
    }

    private fun startLogin() {
        binding.btnLogin.setOnClickListener {
            viewModel.getUsers()
            viewModel.onOldUser(binding.etFirstName.text.toString())
            viewModel.old.observe(viewLifecycleOwner) {
                it.forEach { user ->
                    if (user.name.toString() == binding.etFirstName.text.toString()) {
                        requireActivity().supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.main_activity_container, FragmentProfile.newInstance())
                            .commit()
                    } else {
                        Toast.makeText(requireActivity(), "....", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}


