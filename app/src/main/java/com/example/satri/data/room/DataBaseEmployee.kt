package com.example.satri.data.room

import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.satri.App

@androidx.room.Database(
    entities = [
        HistoryEntity::class
    ],
    version = 1,
    exportSchema = false
)

abstract class DataBaseEmployee : RoomDatabase() {

    abstract fun employeeDao(): HistoryDAO

    companion object {
        private const val DB_NAME = "add_user_new.db"

        val db: DataBaseEmployee by lazy {
            Room.databaseBuilder(
                App.appInstance,
                DataBaseEmployee::class.java,
                DB_NAME
            ).build()
        }
    }

}