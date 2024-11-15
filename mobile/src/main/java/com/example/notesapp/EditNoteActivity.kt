package com.example.notesapp

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class EditNoteActivity : AppCompatActivity() {

    private lateinit var titleEditText: EditText
    private lateinit var contentEditText: EditText
    private lateinit var saveButton: FloatingActionButton
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editnote)

        // Inicializar los elementos de la interfaz
        titleEditText = findViewById(R.id.createtitleofnote)
        contentEditText = findViewById(R.id.createcontentofnote)
        saveButton = findViewById(R.id.save_note_button)
        progressBar = findViewById(R.id.progressbarofcreatenote)

        // Obtener datos de la nota desde el Intent
        val noteTitle = intent.getStringExtra("noteTitle")
        val noteContent = intent.getStringExtra("noteContent")

        // Mostrar datos de la nota en los EditText
        titleEditText.setText(noteTitle)
        contentEditText.setText(noteContent)

        // Configurar el botón de guardar
        saveButton.setOnClickListener {
            saveNote()
        }
    }

    private fun saveNote() {
        val title = titleEditText.text.toString().trim()
        val content = contentEditText.text.toString().trim()

        if (title.isEmpty() || content.isEmpty()) {
            Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
            return
        }

        // Mostrar el indicador de progreso
        progressBar.visibility = View.VISIBLE

        // Simular guardado de la nota
        progressBar.postDelayed({
            // Ocultar el indicador de progreso
            progressBar.visibility = View.GONE
            Toast.makeText(this, "Nota actualizada", Toast.LENGTH_SHORT).show()
            finish()  // Cerrar actividad después de guardar la nota
        }, 1000)  // Simulación de 1 segundo para el guardado
    }
}