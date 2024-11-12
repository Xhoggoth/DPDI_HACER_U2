package com.example.notesapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CreateNoteActivity : AppCompatActivity() {

    private lateinit var titleEditText: EditText
    private lateinit var contentEditText: EditText
    private lateinit var saveButton: Button
    private lateinit var goToEditButton: Button
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_createnote)

        // Inicializar los elementos
        titleEditText = findViewById(R.id.titleofnotedetail)  // ID para el título
        contentEditText = findViewById(R.id.contentofnotedetail) // ID para el contenido
        saveButton = findViewById(R.id.save_edit_note_button)   // ID para el botón guardar
        goToEditButton = findViewById(R.id.goto_main_activity_button)   // ID para el botón de edición
        progressBar = findViewById(R.id.progressbarofcreatenote)

        // Configurar el botón de guardar
        saveButton.setOnClickListener {
            saveNote()
        }

        // Configurar el botón para ir a la edición
        goToEditButton.setOnClickListener {
            goToEditNote()
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
            Toast.makeText(this, "Nota guardada", Toast.LENGTH_SHORT).show()
            finish()  // Cerrar actividad después de guardar la nota
        }, 1000)  // Simulación de 1 segundo para el guardado
    }

    private fun goToEditNote() {
        // Lógica para ir a la actividad de edición de nota
        // Esto podría ser un Intent para abrir otra actividad
        Toast.makeText(this, "Ir a editar nota", Toast.LENGTH_SHORT).show()
    }
}
