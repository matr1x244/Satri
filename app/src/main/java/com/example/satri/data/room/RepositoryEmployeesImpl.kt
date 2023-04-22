package com.example.satri.data.room

class RepositoryEmployeesImpl(private val database: DataBaseEmployee) : RepositoryEmployees {

    override suspend fun saveUser(firstName: String, lastName: String, email: String) {
       database.employeeDao().insert(
            HistoryEntity(
            name = firstName,
            last_name = lastName,
            email = email,
            password = null
        )
        )
    }

    override suspend fun oldUser(firstName: String): List<HistoryEntity> {
       return database.employeeDao().getDataByUser(name = firstName)
    }

    override suspend fun deleteUser() {
        return database.employeeDao().deleteAll()
    }

    override suspend fun getUser(): List<HistoryEntity> {
        return database.employeeDao().allHistory()
    }
}