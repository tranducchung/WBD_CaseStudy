package com.codegym.cms.service;

import com.codegym.cms.model.Note;

public interface NoteService {
    Iterable<Note> findAll();

    Note findById(int id);

    void save(Note note);

    void remove(int id);

}
