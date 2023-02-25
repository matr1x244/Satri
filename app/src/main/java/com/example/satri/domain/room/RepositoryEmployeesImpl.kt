package com.example.satri.domain.room

class RepositoryEmployeesImpl() : RepositoryEmployees {

    override suspend fun saveEntity(employee: String) {
        DataBaseEmployee.db.employeeDao().insert(convertToEntity(employee))
    }


    private fun convertToEntity(employee: String): HistoryEntity {
        return HistoryEntity(
            name = employee
        )
    }
}