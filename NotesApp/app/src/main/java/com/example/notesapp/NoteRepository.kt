package com.example.notesapp

import androidx.lifecycle.LiveData
import org.w3c.dom.Node

class NoteRepository(private val noteDao: NoteDao) {
    val allNotes:  LiveData<List<Note>> = noteDao.getAllNotes()

    suspend fun insert(note: Note){
        noteDao.insert(note)
    }
    suspend fun delete(note: Note) {
        noteDao.delete(note)
    }
}