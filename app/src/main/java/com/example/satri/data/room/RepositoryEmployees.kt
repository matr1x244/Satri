package com.example.satri.data.room

interface RepositoryEmployees {

    suspend fun saveUser(firstName: String, lastName: String, email: String)

    suspend fun oldUser(firstName: String): List<HistoryEntity>

    suspend fun deleteUser()

    suspend fun getUser(): List<HistoryEntity>

}