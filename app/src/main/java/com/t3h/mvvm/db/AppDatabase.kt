package com.t3h.mvvm.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.t3h.mvvm.db.dao.SongSearchDao
import com.t3h.mvvm.db.entity.SongSearch

@Database(entities = arrayOf(SongSearch::class), version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun songSearchDao(): SongSearchDao
}