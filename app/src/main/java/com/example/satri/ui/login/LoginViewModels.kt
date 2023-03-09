package com.example.satri.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.satri.data.room.HistoryEntity
import com.example.satri.data.room.RepositoryEmployees
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModels(private val repository: RepositoryEmployees) : ViewModel() {

    private val _history = MutableLiveData<List<HistoryEntity>>()
    val history: LiveData<List<HistoryEntity>> = _history

    private val _old = MutableLiveData<List<HistoryEntity>>()
    val old: LiveData<List<HistoryEntity>> = _old

    fun onSaveUser(firstName: String, lastName: String, email: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.saveUser(firstName, lastName, email)
        }
    }

    fun onOldUser(firstName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _old.postValue(repository.oldUser(firstName))
        }
    }

    fun onDeleteUser(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteUser()
        }
    }

    fun getUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            _history.postValue(repository.getUser())
        }
    }
}