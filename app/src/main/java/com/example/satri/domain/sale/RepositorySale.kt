package com.example.satri.domain.sale

import com.example.satri.domain.sale.models.Sale

interface RepositorySale {

    suspend fun observerListSale(): Sale
}