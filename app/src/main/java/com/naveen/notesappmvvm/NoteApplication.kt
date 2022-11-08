package com.naveen.notesappmvvm

import android.app.Application
import com.naveen.notesappmvvm.Repository.NoteRepository
import com.naveen.notesappmvvm.Room.NoteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class NoteApplication : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy { NoteDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { NoteRepository(database.getNoteDao()) }

}