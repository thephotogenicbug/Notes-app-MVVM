package com.naveen.notesappmvvm.Room

import androidx.room.*
import com.naveen.notesappmvvm.Model.Note
import kotlinx.coroutines.flow.Flow


@Dao
interface NoteDAO {

    @Insert
   suspend fun insert(note : Note)

   @Update
   suspend fun update(note: Note)

   @Delete
   suspend fun delete(note: Note)

   @Query("SELECT * FROM note_table ORDER BY id ASC")
   fun getAllNotes() : Flow<List<Note>>

    @Query("DELETE FROM note_table")
     fun deleteAllNotes()
}