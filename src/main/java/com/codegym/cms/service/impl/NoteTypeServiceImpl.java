package com.codegym.cms.service.impl;

import com.codegym.cms.model.NoteType;
import com.codegym.cms.repository.NoteTypeRepository;
import com.codegym.cms.service.NoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class NoteTypeServiceImpl implements NoteTypeService {

    @Autowired
    NoteTypeRepository noteTypeRepository;
    @Override
    public Page<NoteType> findAll(Pageable pageable) {
        return noteTypeRepository.findAll(pageable);
    }

    @Override
    public NoteType findById(int id) {
        return noteTypeRepository.findOne(id);
    }

    @Override
    public void save(NoteType noteType) {
        noteTypeRepository.save(noteType);
    }

    @Override
    public void remove(int id) {
        noteTypeRepository.delete(id);
    }

}
