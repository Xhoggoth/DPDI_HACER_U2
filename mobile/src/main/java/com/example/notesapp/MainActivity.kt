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
        setContentView(R.layout.activity_main)  // Asegúrate de que el nombre del layout sea activity_main.xml

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
    }
}
