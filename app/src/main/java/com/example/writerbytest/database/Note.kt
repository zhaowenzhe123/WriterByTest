package com.example.writerbytest.database

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import androidx.annotation.NonNull
import java.sql.Time

@Entity
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id :Int,
    @NonNull @ColumnInfo(name = "content")
    val noteContent :String,
    @NonNull @ColumnInfo(name = "time")
    val noteTime :Int,
    @NonNull @ColumnInfo(name = "label")
    val noteLabel :String

)