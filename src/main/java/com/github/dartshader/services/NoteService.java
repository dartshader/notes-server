package com.github.dartshader.services;

import com.github.dartshader.exceptions.ApplicationException;
import com.github.dartshader.models.Note;
import com.github.dartshader.repositories.NoteRepository;
import lombok.CustomLog;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@CustomLog
@Singleton
public class NoteService {

    private static final String NOT_FOUND = "No existing note with id %s";

    @Inject
    NoteRepository noteRepository;

    public Note saveNote(Note note) {
        if (note.getId() != null) {
            if (!noteRepository.existsById(note.getId())) {
                throw new ApplicationException(String.format(NOT_FOUND, note.getId()));
            }
            return noteRepository.update(note);
        }
        return noteRepository.save(note);
    }

    public void deleteNote(long id) {
        noteRepository.deleteById(id);
    }

    public List<Note> findAllNotes() {
        return noteRepository.findAll();
    }

    public Note findNoteById(long id) {
        return noteRepository.findById(id).orElseThrow(() -> new ApplicationException(String.format(NOT_FOUND, id)));
    }

}
