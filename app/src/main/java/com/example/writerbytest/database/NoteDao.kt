package com.example.writerbytest.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface NoteDao {
    @Update
    suspend fun update(note: Note)

    @Insert
    suspend fun insert(note: Note)

    @Delete
    suspend fun delete(note: Note)

    @Query("SELECT * from note ")
    fun getNotes()

    @Query("SELECT * from note WHERE id = :id")
    fun getNote(id:Int)
}