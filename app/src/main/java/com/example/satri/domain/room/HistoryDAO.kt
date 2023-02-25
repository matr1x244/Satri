package com.example.satri.domain.room

import androidx.room.*

@Dao
interface HistoryDAO {

    @Query("SELECT * FROM employee_table")
    fun allHistory(): List<HistoryEntity>

    @Query("SELECT * FROM employee_table WHERE name LIKE :name")
    fun getDataByWord(name: String): List<HistoryEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entity: HistoryEntity)

    @Update
    fun update(entity: HistoryEntity)

    @Delete
    fun delete(entity: HistoryEntity)

    @Query("DELETE FROM employee_table WHERE name = :name")
    fun deleteByEmployeeName(name: String?)

    @Query("DELETE FROM employee_table")
    fun deleteAll()

}
