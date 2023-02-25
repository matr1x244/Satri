package com.example.satri.domain.room

interface RepositoryEmployees {

    suspend fun saveEntity(employee: String)

}