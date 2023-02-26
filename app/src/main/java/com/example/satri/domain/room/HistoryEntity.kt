package com.example.satri.domain.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class HistoryEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    var name: String?,
    val last_name: String?,
    val email: String?,
    val password: String?
)