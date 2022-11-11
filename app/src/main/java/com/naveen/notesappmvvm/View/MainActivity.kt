package com.naveen.notesappmvvm.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.naveen.notesappmvvm.Adapters.NoteAdapter
import com.naveen.notesappmvvm.NoteApplication
import com.naveen.notesappmvvm.R
import com.naveen.notesappmvvm.ViewModel.NoteViewModel
import com.naveen.notesappmvvm.ViewModel.NoteViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var noteViewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView : RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val noteAdapter = NoteAdapter()
        recyclerView.adapter = noteAdapter

        val viewModelFactory = NoteViewModelFactory((application as NoteApplication).repository)

        noteViewModel = ViewModelProvider(this,viewModelFactory ).get(NoteViewModel::class.java)

        noteViewModel.myAllNotes.observe(this, Observer { notes ->

            // update UI
            noteAdapter.setNote(notes)

        })
    }
}