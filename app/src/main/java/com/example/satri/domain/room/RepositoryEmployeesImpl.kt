package com.example.satri.domain.room

class RepositoryEmployeesImpl() : RepositoryEmployees {

    override suspend fun saveUser(firstName: String, lastName: String, email: String) {
        DataBaseEmployee.db.employeeDao().insert(HistoryEntity(
            name = firstName,
            last_name = lastName,
            email = email,
            password = null
        ))
    }

    override suspend fun oldUser(firstName: String, password: String) {
        DataBaseEmployee.db.employeeDao().getDataByWord(name = firstName, password = password)
    }

    override suspend fun getUser(): List<HistoryEntity> {
        return DataBaseEmployee.db.employeeDao().allHistory()
    }
}