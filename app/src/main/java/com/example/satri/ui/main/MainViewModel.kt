package com.example.satri.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.satri.data.local.LocalCategory
import com.example.satri.domain.category.Category
import com.example.satri.domain.lastest.RepositoryLatest
import com.example.satri.domain.lastest.models.LatestAll
import com.example.satri.domain.sale.RepositorySale
import com.example.satri.domain.sale.models.Sale
import kotlinx.coroutines.*

class MainViewModel(
    private val repCategory: LocalCategory,
    private val repLatest: RepositoryLatest,
    private val repSale: RepositorySale
) : ViewModel() {

    private val _category = MutableLiveData<List<Category>>()
    val category: LiveData<List<Category>> = _category

    private val _latest = MutableLiveData<LatestAll>()
    val latest: LiveData<LatestAll> = _latest

    private val _sale = MutableLiveData<Sale>()
    val sale: LiveData<Sale> = _sale

    private val _inProgress = MutableLiveData<Boolean>()
    val inProgress: LiveData<Boolean> = _inProgress

    private val coroutineScope = CoroutineScope(Dispatchers.IO)
    fun onShowListCategory() {
        coroutineScope.launch {
            val result = repCategory.getListCategory()
            withContext(Dispatchers.Main) {
                _category.postValue(result)
            }
        }
    }

    fun onShowListLatest() {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
            Log.d("@@@", "No success onShowListLatest $throwable")
            _inProgress.postValue(true)
        }
        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            val result = repLatest.observerListLatest()
            withContext(Dispatchers.Main) {
                _latest.postValue(result)
                _inProgress.postValue(false)
            }
        }
    }

    fun onShowListSale() {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
            Log.d("@@@", "No success onShowListSale $throwable")
            _inProgress.postValue(true)
        }
        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            val result = repSale.observerListSale()
            withContext(Dispatchers.Main) {
                _sale.postValue(result)
                _inProgress.postValue(false)
            }
        }
    }

    fun getAll() {
        coroutineScope.launch(Dispatchers.IO) {
            try {
                coroutineScope {
                    listOf(
                        async { onShowListLatest() },
                        async { onShowListSale() }
                    ).joinAll()
                }
            } catch (e: Throwable) {
                println("@@@@ $e")
            }
        }
    }

    override fun onCleared() {
        coroutineScope.cancel()
        super.onCleared()
    }
}

