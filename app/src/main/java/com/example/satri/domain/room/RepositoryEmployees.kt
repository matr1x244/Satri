package com.example.satri.domain.room

interface RepositoryEmployees {

    suspend fun saveUser(firstName: String, lastName: String, email: String)

    suspend fun oldUser(firstName: String, password: String)

    suspend fun getUser(): List<HistoryEntity>

}