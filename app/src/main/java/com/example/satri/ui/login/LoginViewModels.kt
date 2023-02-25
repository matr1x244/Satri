package com.example.satri.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.satri.domain.room.RepositoryEmployees
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModels(private val repository: RepositoryEmployees) : ViewModel() {

    private val _history = MutableLiveData<String>()
    val history: LiveData<String> = _history

    fun onSaveUser(employee: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val user = repository.saveEntity(employee) //
            withContext(Dispatchers.Main) {
                _history.value
            }
        }
    }
}