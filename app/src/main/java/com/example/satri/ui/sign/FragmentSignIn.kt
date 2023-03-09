package com.example.satri.ui.sign

import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import com.example.satri.R
import com.example.satri.databinding.FragmentSigninBinding
import com.example.satri.ui.login.FragmentLogin
import com.example.satri.ui.login.LoginViewModels
import com.example.satri.ui.main.FragmentMain
import com.example.satri.utils.ViewBindingFragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.qualifier.named

class FragmentSignIn : ViewBindingFragment<FragmentSigninBinding>(FragmentSigninBinding::inflate) {

    companion object {
        fun newInstance() = FragmentSignIn()
    }

    private val viewModel: LoginViewModels by viewModel(named("login_view_model"))

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        emailVerification()
        loginIn()

    }

    private fun emailVerification() {
        binding.btnSignIn.setOnClickListener {
            if (isValidEmail(binding.etEmail.text.toString())) {
                viewModel.onSaveUser(
                    binding.etFirstName.text.toString(),
                    binding.etFirstName.text.toString(),
                    binding.etEmail.text.toString()
                )
                requireActivity().supportFragmentManager
                    .beginTransaction()
                    .add(R.id.main_activity_container, FragmentMain.newInstance())
                    .commit()
            } else {
                Toast.makeText(
                    requireActivity(),
                    getString(R.string.toast_validaty_email),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun isValidEmail(emailText: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(emailText).matches()
    }

    private fun loginIn() {
        binding.logIn.setOnClickListener {
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_activity_container, FragmentLogin.newInstance())
                .addToBackStack(null)
                .commit()
        }
    }

}