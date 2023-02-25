package com.example.satri.domain.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "employee_table")
data class HistoryEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String?
)