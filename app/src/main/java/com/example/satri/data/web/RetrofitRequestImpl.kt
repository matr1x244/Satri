package com.example.satri.data.web

import com.example.satri.domain.lastest.RepositoryLatest
import com.example.satri.domain.lastest.models.LatestAll
import com.example.satri.domain.sale.RepositorySale
import com.example.satri.domain.sale.models.Sale

class RetrofitRequestImpl(private val api: LatestAPI) : RepositoryLatest, RepositorySale {

    override suspend fun observerListLatest(): LatestAll {
        return api.listLatest()
    }

    override suspend fun observerListSale(): Sale {
        return api.listSale()
    }
}