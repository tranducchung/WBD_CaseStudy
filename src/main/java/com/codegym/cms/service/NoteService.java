package com.codegym.cms.service;

import com.codegym.cms.model.Note;
import com.codegym.cms.model.NoteType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NoteService {
    Page<Note> findAll(Pageable pageable);

    Note findById(int id);

    void save(Note note);

    void remove(int id);

    Page<Note> findAllByTitle(String title,Pageable pageable);

    Page<Note> findAllByTitleAndType(String title,NoteType noteType,Pageable pageable);

    Page<Note> findAllByType(NoteType noteType, Pageable pageable);

}
