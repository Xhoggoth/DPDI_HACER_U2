package com.example.notesapp

import android.content.Intent
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

        // Inicializar vistas
        titleEditText = findViewById(R.id.createtitleofnote)
        contentEditText = findViewById(R.id.createcontentofnote)
        saveButton = findViewById(R.id.save_note_button)
        progressBar = findViewById(R.id.progressbarofcreatenote)

        // Configurar el botón de guardar
        saveButton.setOnClickListener {
            saveNoteAndGoToMain()
        }
    }

    private fun saveNoteAndGoToMain() {
        val title = titleEditText.text.toString().trim()
        val content = contentEditText.text.toString().trim()

        if (title.isEmpty() || content.isEmpty()) {
            Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
            return
        }

        // Mostrar el indicador de progreso
        progressBar.visibility = View.VISIBLE

        // Simular el guardado de la nota
        progressBar.postDelayed({
            // Ocultar el indicador de progreso
            progressBar.visibility = View.GONE
            Toast.makeText(this, "Nota guardada", Toast.LENGTH_SHORT).show()

            // Redirigir a MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

            // Finalizar esta actividad
            finish()
        }, 1000) // Simulación de 1 segundo
    }
}
