package com.github.dartshader.repositories;

import com.github.dartshader.models.Note;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {}
