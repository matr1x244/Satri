package com.example.satri.ui.profile

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.bumptech.glide.Glide
import com.example.satri.R
import com.example.satri.databinding.FragmentProfileBinding
import com.example.satri.ui.login.LoginViewModels
import com.example.satri.ui.sign.FragmentSignIn
import com.example.satri.utils.ViewBindingFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class FragmentProfile :
    ViewBindingFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {

    companion object {
        fun newInstance() = FragmentProfile()
    }

    private val viewModel: LoginViewModels by viewModel()
    private val job = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + job)
    private lateinit var intent: Intent
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        menu()
        profileAvatar()
        profileName()
        logOut()
    }

    private fun menu() {
        val bottomNavigationView = binding.menuBottom
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home_menu -> Toast.makeText(requireActivity(), "1", Toast.LENGTH_SHORT).show()
                R.id.chat_menu -> Toast.makeText(requireActivity(), "2", Toast.LENGTH_SHORT).show()
            }
            true
        }
        bottomNavigationView.selectedItemId = R.id.profile_menu
    }

    private fun profileAvatar() {
        intent = Intent(
            Intent.ACTION_PICK,
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        )
        resultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                if (data != null) {
                    val imageUri = data.data
                    Glide.with(binding.avatar)
                        .load(imageUri)
                        .centerInside()
                        .circleCrop()
                        .into(binding.avatar)
                }
            }
        }
        binding.avatar.setOnClickListener {
            resultLauncher.launch(
                Intent.createChooser(
                    intent,
                    "Выбрать аватар"
                )
            )
        }
    }

    private fun profileName() {
        viewModel.getUsers()
        viewModel.history.observe(viewLifecycleOwner) {
            it.forEach { name ->
                uiScope.launch {
                    binding.tvName.text = name.name.toString()
                }
            }
        }
    }

    private fun logOut() {
        binding.boxLogout.setOnClickListener {
            viewModel.getUsers()
            viewModel.onDeleteUser()
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_activity_container, FragmentSignIn.newInstance())
                .commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        uiScope.cancel()
    }
}