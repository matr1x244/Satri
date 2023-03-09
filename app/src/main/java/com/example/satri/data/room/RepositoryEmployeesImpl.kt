package com.example.satri.data.room

class RepositoryEmployeesImpl() : RepositoryEmployees {

    override suspend fun saveUser(firstName: String, lastName: String, email: String) {
        DataBaseEmployee.db.employeeDao().insert(
            HistoryEntity(
            name = firstName,
            last_name = lastName,
            email = email,
            password = null
        )
        )
    }

    override suspend fun oldUser(firstName: String): List<HistoryEntity> {
       return DataBaseEmployee.db.employeeDao().getDataByUser(name = firstName)
    }

    override suspend fun deleteUser() {
        return DataBaseEmployee.db.employeeDao().deleteAll()
    }

    override suspend fun getUser(): List<HistoryEntity> {
        return DataBaseEmployee.db.employeeDao().allHistory()
    }
}