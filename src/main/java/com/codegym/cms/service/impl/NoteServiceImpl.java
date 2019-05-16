package com.codegym.cms.service.impl;

import com.codegym.cms.model.Note;
import com.codegym.cms.model.NoteType;
import com.codegym.cms.repository.NoteRepository;
import com.codegym.cms.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class NoteServiceImpl implements NoteService {
    @Autowired
    NoteRepository noteRepository;

    @Override
    public Page<Note> findAll(Pageable pageable) {
        return noteRepository.findAll(pageable);
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

    @Override
    public Page<Note> findAllByTitle(String title, Pageable pageable) {
        return noteRepository.findAllByTitleContaining(title,pageable);
    }

    @Override
    public Page<Note> findAllByTitleAndType(String title,NoteType noteType, Pageable pageable) {
        return noteRepository.findAllByTitleContainingAndType(title,noteType,pageable);
    }

    @Override
    public Page<Note> findAllByType(NoteType noteType, Pageable pageable) {
        return noteRepository.findAllByType(noteType,pageable);
    }
}
