package com.example.notesapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.appcompat.app.AppCompatActivity

class CreateNoteActivity : AppCompatActivity() {

    private lateinit var titleEditText: EditText
    private lateinit var contentEditText: EditText
    private lateinit var saveButton: FloatingActionButton
    private lateinit var goToMainButton: FloatingActionButton
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_createnote)

        titleEditText = findViewById(R.id.titleofnotedetail)
        contentEditText = findViewById(R.id.contentofnotedetail)
        saveButton = findViewById(R.id.save_edit_note_button)
        goToMainButton = findViewById(R.id.goto_main_activity_button)
        progressBar = findViewById(R.id.progressbarofcreatenote)

        progressBar.visibility = View.GONE

        saveButton.setOnClickListener {
            saveNote()
        }

        goToMainButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun saveNote() {
        val title = titleEditText.text.toString().trim()
        val content = contentEditText.text.toString().trim()

        if (title.isEmpty() || content.isEmpty()) {
            Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
            return
        }

        progressBar.visibility = View.VISIBLE

        progressBar.postDelayed({
            progressBar.visibility = View.GONE
            Toast.makeText(this, "Nota guardada", Toast.LENGTH_SHORT).show()
            finish()
        }, 1000)
    }
}
