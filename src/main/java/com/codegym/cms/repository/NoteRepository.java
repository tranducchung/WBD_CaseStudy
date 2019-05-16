package com.codegym.cms.repository;

import com.codegym.cms.model.Note;
import com.codegym.cms.model.NoteType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface NoteRepository extends PagingAndSortingRepository<Note,Integer> {
    Page<Note> findAllByTitleContaining(String title, Pageable pageable);

    Page<Note> findAllByTitleContainingAndType(String title, NoteType type, Pageable pageable);

    Page<Note> findAllByType(NoteType type, Pageable pageable);
}
