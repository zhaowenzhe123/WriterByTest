package com.example.writerbytest.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.writerbytest.database.Note
import com.example.writerbytest.database.NoteDao
import java.util.concurrent.Flow

class NoteViewModel(private val noteDao: NoteDao):ViewModel(){


    fun allNotes()  = noteDao.getNotes()
    fun note(id :Int)  = noteDao.getNote(id)

}

//样板代码实例化视图模型
/**
 * NoteViewModelFactory.create() 实例化 NoteViewModelFactory 对象
 * ，让您的视图模型可以感知生命周期而不必由 fragment 直接进行处理。
 */
class NoteViewModelFactory(
    private val noteDao :NoteDao
) :ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NoteViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return NoteViewModel(noteDao) as T
        }
        throw IllegalArgumentException("UnKnown ViewModel class")
    }
}