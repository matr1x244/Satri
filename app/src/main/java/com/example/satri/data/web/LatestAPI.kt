package com.example.satri.data.web

import com.example.satri.domain.lastest.models.LatestAll
import com.example.satri.domain.sale.models.Sale
import retrofit2.http.GET

interface LatestAPI {

    @GET("cc0071a1-f06e-48fa-9e90-b1c2a61eaca7")
    suspend fun listLatest(): LatestAll

    @GET("a9ceeb6e-416d-4352-bde6-2203416576ac")
    suspend fun listSale(): Sale

}