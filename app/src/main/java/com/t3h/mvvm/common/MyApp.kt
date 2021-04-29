package com.t3h.mvvm.common

import android.app.Application
import androidx.room.Room
import com.t3h.mvvm.db.AppDatabase

class MyApp:Application(){
    companion object{
        private lateinit var db: AppDatabase
        fun getDB() = db
    }
    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "database-name-2.sqlite"
        ).allowMainThreadQueries()
            .build()
    }
}