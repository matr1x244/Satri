package com.example.satri.domain.lastest

import com.example.satri.domain.lastest.models.Latest
import com.example.satri.domain.lastest.models.LatestAll

interface RepositoryLatest {

    suspend fun observerListLatest(): LatestAll
}