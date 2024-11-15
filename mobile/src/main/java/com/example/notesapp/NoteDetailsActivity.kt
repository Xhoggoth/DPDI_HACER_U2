package com.example.notesapp

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class NoteDetailsActivity : AppCompatActivity() {

    private lateinit var noteTitleTextView: TextView
    private lateinit var noteContentTextView: TextView
    private lateinit var editNoteButton: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notedetails)

        // Inicializar las vistas
        noteTitleTextView = findViewById(R.id.note_title)
        noteContentTextView = findViewById(R.id.note_content)
        editNoteButton = findViewById(R.id.edit_note_button)

        // Obtener los datos del Intent
        val noteTitle = intent.getStringExtra("noteTitle")
        val noteContent = intent.getStringExtra("noteContent")

        // Verificar si los datos existen
        if (noteTitle != null && noteContent != null) {
            noteTitleTextView.text = noteTitle
            noteContentTextView.text = noteContent
        } else {
            // Manejo de error si los datos no se pasan correctamente
            Toast.makeText(this, "Error al cargar la nota", Toast.LENGTH_SHORT).show()
            finish() // Cerrar la actividad si no hay datos
        }

        // Configurar el botón de editar
        editNoteButton.setOnClickListener {
            // Abre la actividad de edición de la nota
            val intent = Intent(this, CreateNoteActivity::class.java).apply {
                putExtra("noteTitle", noteTitle)   // Pasar título de la nota
                putExtra("noteContent", noteContent) // Pasar contenido de la nota
            }
            startActivity(intent)
        }
    }
}
