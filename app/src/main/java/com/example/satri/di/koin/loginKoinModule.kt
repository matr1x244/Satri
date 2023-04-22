package com.example.satri.di.koin

import com.example.satri.data.room.DataBaseEmployeeBuilder
import com.example.satri.data.room.RepositoryEmployees
import com.example.satri.data.room.RepositoryEmployeesImpl
import com.example.satri.ui.login.LoginViewModels
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val loginKoinModule = module {

    single(named("database")) {
        DataBaseEmployeeBuilder.getInstance(androidContext())
    }
    single<RepositoryEmployees>(named("login")) {
        RepositoryEmployeesImpl(get(named("database")))
    }

    viewModel(named("login_view_model")) { LoginViewModels(get(named("login"))) }

}