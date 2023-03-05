package com.example.satri.di.koin

import com.example.satri.data.local.LocalCategory
import com.example.satri.data.web.LatestAPI
import com.example.satri.data.web.RetrofitRequestImpl
import com.example.satri.domain.lastest.RepositoryLatest
import com.example.satri.domain.room.RepositoryEmployeesImpl
import com.example.satri.domain.room.RepositoryEmployees
import com.example.satri.domain.sale.RepositorySale
import com.example.satri.ui.login.LoginViewModels
import com.example.satri.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val appModuleKoin = module {

    val apiUrl = "https://run.mocky.io/v3/"

    single<RepositoryLatest> { RetrofitRequestImpl(get()) }
    single<RepositorySale> {RetrofitRequestImpl(get())}
    single<LatestAPI> { get<Retrofit>().create(LatestAPI::class.java) }

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
    factory { LocalCategory() }

    viewModel { LoginViewModels(get()) }
    viewModel { MainViewModel(get(),get(),get())}
}