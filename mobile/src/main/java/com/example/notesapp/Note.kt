package com.example.notesapp

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class NoteDetailsActivity : AppCompatActivity() {

    private lateinit var titleEditText: EditText
    private lateinit var contentEditText: EditText
    private lateinit var saveButton: FloatingActionButton
    private lateinit var goToEditButton: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notedetails)

        // Inicialización de los elementos
        titleEditText = findViewById(R.id.titleofnotedetail)
        contentEditText = findViewById(R.id.contentofnotedetail)
        saveButton = findViewById(R.id.save_edit_note_button)
        goToEditButton = findViewById(R.id.goto_main_activity_button)

        // Acción del botón para guardar la nota
        saveButton.setOnClickListener {
            // Lógica para guardar la nota
            val title = titleEditText.text.toString()
            val content = contentEditText.text.toString()

            if (title.isNotEmpty() && content.isNotEmpty()) {
                // Aquí puedes agregar la lógica para guardar la nota
                // Por ejemplo, puedes guardar la nota en una base de datos o en un archivo

                // Muestra un mensaje de éxito
                // Toast.makeText(this, "Nota guardada", Toast.LENGTH_SHORT).show()
            } else {
                // Si los campos están vacíos, muestra un mensaje de error
                // Toast.makeText(this, "Por favor ingresa título y contenido", Toast.LENGTH_SHORT).show()
            }
        }

        // Acción del botón para editar la nota
        goToEditButton.setOnClickListener {
            // Lógica para editar la nota
            // Puedes cambiar el modo de los EditText para permitir la edición o navegar a otra actividad
            titleEditText.isEnabled = true
            contentEditText.isEnabled = true
        }
    }
}
