package com.example.satri.data.room

import androidx.room.*

@Dao
interface HistoryDAO {

    @Query("SELECT * FROM user_table")
    fun allHistory(): List<HistoryEntity>

    @Query("SELECT * FROM user_table WHERE name LIKE :name")
    fun getDataByUser(name: String): List<HistoryEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entity: HistoryEntity)

    @Update
    fun update(entity: HistoryEntity)

    @Delete
    fun delete(entity: HistoryEntity)

    @Query("DELETE FROM user_table WHERE name = :name")
    fun deleteByEmployeeName(name: String)

    @Query("DELETE FROM user_table")
    fun deleteAll()

}
