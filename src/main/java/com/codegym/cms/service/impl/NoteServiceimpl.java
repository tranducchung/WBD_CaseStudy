package com.codegym.cms.service.impl;

import com.codegym.cms.model.Note;
import com.codegym.cms.repository.NoteRepository;
import com.codegym.cms.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;

public class NoteServiceimpl implements NoteService {
    @Autowired
    NoteRepository noteRepository;

    @Override
    public Iterable<Note> findAll() {
        return noteRepository.findAll();
    }

    @Override
    public Note findById(int id) {
        return noteRepository.findOne(id);
    }

    @Override
    public void save(Note note) {
        noteRepository.save(note);
    }

    @Override
    public void remove(int id) {
        noteRepository.delete(id);
    }
}
