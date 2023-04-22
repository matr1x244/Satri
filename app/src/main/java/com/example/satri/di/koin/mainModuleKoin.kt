package com.example.satri.di.koin

import com.example.satri.data.local.LocalCategory
import com.example.satri.data.web.LatestAPI
import com.example.satri.data.web.RetrofitRequestImpl
import com.example.satri.domain.lastest.RepositoryLatest
import com.example.satri.domain.sale.RepositorySale
import com.example.satri.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val mainModuleKoin = module {

    val apiUrl = "https://run.mocky.io/v3/"

    single<RepositoryLatest>(named("api_latest")) { RetrofitRequestImpl(get()) }
    single<RepositorySale>(named("api_sale")) { RetrofitRequestImpl(get()) }
    single<LatestAPI> { get<Retrofit>().create(LatestAPI::class.java) }

    single {
        Retrofit.Builder()
            .baseUrl(apiUrl)
            .addCallAdapterFactory(get(named("rx_java_adapter")))
            .addConverterFactory(get(named("gson_converter")))
            .build()
    }

    factory<Converter.Factory>(named("gson_converter")) { GsonConverterFactory.create() }
    factory<CallAdapter.Factory>(named("rx_java_adapter")) { RxJava3CallAdapterFactory.create() }

    factory(named("local_category")) { LocalCategory() }

    viewModel(named("main_view_model")) {
        MainViewModel(
            get(named("local_category")),
            get(named("api_latest")),
            get(
                named("api_sale")
            )
        )
    }
}