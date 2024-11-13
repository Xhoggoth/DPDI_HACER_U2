package com.example.notesapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class Note(
    val title: String,
    val content: String
)

class NotesAdapter(private val notesList: List<Note>) : RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        return NoteViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote = notesList[position]
        holder.titleTextView.text = currentNote.title
        holder.contentTextView.text = currentNote.content
    }

    override fun getItemCount() = notesList.size

    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.note_title)
        val contentTextView: TextView = itemView.findViewById(R.id.note_content)
    }
}
