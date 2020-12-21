package com.github.dartshader.controllers;

import com.github.dartshader.models.Note;
import com.github.dartshader.services.NoteService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import lombok.CustomLog;

import javax.inject.Inject;
import java.util.List;

@CustomLog
@Controller("/notes")
public class NotesController {

    @Inject
    NoteService noteService;

    @Get
    public HttpResponse<List<Note>> findAllNotes() {
        return HttpResponse.status(HttpStatus.OK).body(noteService.findAllNotes());
    }

    @Get("/{id}")
    public HttpResponse<Note> findNote(@PathVariable Long id) {
        return HttpResponse.status(HttpStatus.OK).body(noteService.findNoteById(id));
    }

    @Post
    public HttpResponse<Note> saveNote(@Body Note note) {
        return HttpResponse.status(HttpStatus.OK).body(noteService.saveNote(note));
    }

}
