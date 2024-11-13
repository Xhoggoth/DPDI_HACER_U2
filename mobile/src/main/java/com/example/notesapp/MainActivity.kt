package com.example.notesapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var botonFlotanteCrearNota: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializa el RecyclerView
        recyclerView = findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Inicializa el FloatingActionButton y configura el evento de clic
        botonFlotanteCrearNota = findViewById(R.id.createnotefab)
        botonFlotanteCrearNota.setOnClickListener {
            // Navega a la actividad para crear una nueva nota
            val intent = Intent(this, CreateNoteActivity::class.java)
            startActivity(intent)
        }

        // Lista de notas de ejemplo
        val notesList = listOf(
            Note("Nota 1", "Contenido de la primera nota"),
            Note("Nota 2", "Contenido de la segunda nota"),
            Note("Nota 3", "Contenido de la tercera nota")
        )

        // Configurar el adapter del RecyclerView
        val adapter = NotesAdapter(notesList)
        recyclerView.adapter = adapter
    }
}
