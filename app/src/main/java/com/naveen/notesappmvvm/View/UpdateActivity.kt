package com.naveen.notesappmvvm.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.naveen.notesappmvvm.R

class UpdateActivity : AppCompatActivity() {

    lateinit var editTextTitleUpdate : EditText
    lateinit var editTextDescriptionUpdate : EditText
    lateinit var buttonCancelUpdate : Button
    lateinit var buttonSaveUpdate : Button


    var currentId = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        supportActionBar?.title = "Update Note"

        editTextTitleUpdate = findViewById(R.id.editTextTitleUpdate)
        editTextDescriptionUpdate = findViewById(R.id.editTextDescriptionUpdate)
        buttonCancelUpdate = findViewById(R.id.buttonCancelUpdate)
        buttonSaveUpdate = findViewById(R.id.buttonSaveUpdate)

        getAndSetData()

        buttonCancelUpdate.setOnClickListener {
            Toast.makeText(applicationContext, "Nothing updated", Toast.LENGTH_SHORT).show()
            finish()
        }

        buttonSaveUpdate.setOnClickListener {
            updateNote()
        }
    }

    fun updateNote(){

        val updatedTitle = editTextTitleUpdate.text.toString()
        val updatedDescription = editTextDescriptionUpdate.text.toString()

        val intent = Intent()
        intent.putExtra("updatedTitle", updatedTitle)
        intent.putExtra("updatedDescription", updatedDescription)
        if(currentId != -1 ){
            intent.putExtra("noteId", currentId)
            setResult(RESULT_OK, intent)
            finish()
        }

    }

    fun getAndSetData(){
        //get
        val currentTitle = intent.getStringExtra("currentTitle")
        val currentDescription = intent.getStringExtra("currentDescription")
         currentId = intent.getIntExtra("currentId", -1)

        //set
        editTextTitleUpdate.setText(currentTitle)
        editTextDescriptionUpdate.setText(currentDescription)
    }

}