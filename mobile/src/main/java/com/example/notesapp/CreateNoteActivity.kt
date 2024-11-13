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
    private lateinit var saveButton: FloatingActionButton  // Usar FloatingActionButton
    private lateinit var goToMainButton: FloatingActionButton  // Renombrado para mayor claridad
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_createnote)

        // Inicializar los elementos
        titleEditText = findViewById(R.id.titleofnotedetail)
        contentEditText = findViewById(R.id.contentofnotedetail)
        saveButton = findViewById(R.id.save_edit_note_button)
        goToMainButton = findViewById(R.id.goto_main_activity_button)  // ID de botón principal
        progressBar = findViewById(R.id.progressbarofcreatenote)

        // Asegurarse de que el ProgressBar está oculto al inicio
        progressBar.visibility = View.GONE

        // Configurar el botón de guardar
        saveButton.setOnClickListener {
            saveNote()
        }

        // Configurar el botón para ir a la actividad principal
        goToMainButton.setOnClickListener {
            goToMainActivity()
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

    private fun goToMainActivity() {
        // Lógica para ir a la pantalla principal
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish() // Cerrar CreateNoteActivity después de navegar
    }
}
