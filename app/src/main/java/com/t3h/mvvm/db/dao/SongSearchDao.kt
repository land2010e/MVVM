package com.t3h.mvvm.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.t3h.mvvm.db.entity.SongSearch

@Dao
interface SongSearchDao {
    @Query("SELECT * FROM SongSearch")
    fun getAll(): MutableList<SongSearch>

    @Query("SELECT * FROM SongSearch where name LIKE :name")
    fun getByName(name: String): MutableList<SongSearch>

    @Query("SELECT * FROM SongSearch where keySearch = :keySearch")
    fun getByKeySearch(keySearch: String): MutableList<SongSearch>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(music: MutableList<SongSearch>)

    @Query("DELETE FROM SongSearch WHERE name = :name")
    fun deleteByName(name: String)
}