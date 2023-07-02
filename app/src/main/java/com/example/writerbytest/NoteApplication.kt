package com.example.writerbytest

import android.app.Application
import com.example.writerbytest.database.NoteRoomDatabase

//  为NoteRoomDatabase的子类  并创建一个lazy属性来存放getDatabase的结果
//最后，为了确保使用的是 NOteApplication 类（而不是默认的基类 Application），
// 需要对清单稍作更改。在 AndroidMainifest.xml 中，
// 将 android:name 属性设为 com.example.writebytest.NoteApplication。
class NoteApplication :Application() {
    val database :NoteRoomDatabase by lazy { NoteRoomDatabase.getDatabase(this) }
}