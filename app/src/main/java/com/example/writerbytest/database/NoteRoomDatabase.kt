package com.example.writerbytest.database

import android.content.Context
import androidx.room.Database
import androidx.room.DatabaseConfiguration
import androidx.room.InvalidationTracker
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper

// 使用单例模式加双重检验模式确保之创建一个数据库  以防出现竞态条件 或其他潜在问题
/**
 * 实例储存在伴生对象中  b
 * 并且还需要用一个方法来返回现有实例或首次创建数据库
 */
@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteRoomDatabase :RoomDatabase() {
    abstract fun noteDao() :NoteDao

    override fun clearAllTables() {
        TODO("Not yet implemented")
    }

    override fun createInvalidationTracker(): InvalidationTracker {
        TODO("Not yet implemented")
    }

    override fun createOpenHelper(config: DatabaseConfiguration): SupportSQLiteOpenHelper {
        TODO("Not yet implemented")
    }

    companion object{
        @Volatile
        private var INSTANCE: NoteRoomDatabase? = null

        fun getDatabase(context: Context):NoteRoomDatabase {
            //单例加双重检测
            return INSTANCE?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NoteRoomDatabase::class.java,
                    "note_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }

    }

}