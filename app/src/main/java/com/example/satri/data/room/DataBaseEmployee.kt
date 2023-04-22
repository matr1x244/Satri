package com.example.satri.data.room

import android.content.Context
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

}

object DataBaseEmployeeBuilder {
    private var instance: DataBaseEmployee? = null
    const val DB_NAME = "add_user.db"

    fun getInstance(context: Context): DataBaseEmployee {
        if (instance == null) {
            synchronized(DataBaseEmployee::class) {
                instance = buildRoomDB(context)
            }
        }
        return instance!!
    }

    private fun buildRoomDB(context: Context) =
        Room.databaseBuilder(
            context.applicationContext,
            DataBaseEmployee::class.java,
            DB_NAME
        ).build()
}