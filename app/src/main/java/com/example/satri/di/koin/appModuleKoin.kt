package com.example.satri.di.koin

import com.example.satri.domain.room.RepositoryEmployeesImpl
import com.example.satri.domain.room.RepositoryEmployees
import com.example.satri.ui.login.LoginViewModels
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val appModuleKoin = module {

    val apiUrl = ""

    single {
        Retrofit.Builder()
            .baseUrl(apiUrl)
            .addCallAdapterFactory(get())
            .addConverterFactory(get())
            .build()
    }

    factory<Converter.Factory> { GsonConverterFactory.create() }
    factory<CallAdapter.Factory> { RxJava3CallAdapterFactory.create() }

    single<RepositoryEmployees> { RepositoryEmployeesImpl() }

    viewModel { LoginViewModels(get()) }
}