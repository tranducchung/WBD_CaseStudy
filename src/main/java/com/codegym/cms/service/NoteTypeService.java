package com.codegym.cms.service;

import com.codegym.cms.model.NoteType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NoteTypeService {
    Page<NoteType> findAll(Pageable pageable);

    NoteType findById(int id);

    void save (NoteType noteType);

    void remove(int id);
}
