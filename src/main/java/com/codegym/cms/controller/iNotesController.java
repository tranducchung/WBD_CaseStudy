package com.codegym.cms.controller;

import com.codegym.cms.model.Note;
import com.codegym.cms.model.NoteType;
import com.codegym.cms.service.NoteService;
import com.codegym.cms.service.NoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class iNotesController {
    @Autowired
    private NoteService noteService;
    @Autowired
    private NoteTypeService noteTypeService;
    @GetMapping("/notes")
    public ModelAndView showListNote(@PageableDefault(value = 11) Pageable pageable, @RequestParam("title")Optional<String> title,@RequestParam("type") Optional<NoteType> type) {
        Page<Note> notes;
        if(title.isPresent()) {
                notes = noteService.findAllByTitle(title.get(),pageable);
            }
        else {
            notes = noteService.findAll(pageable);
        }
        if(type.isPresent()){
            notes = noteService.findAllByType(type.get(),pageable);
        }
      return new ModelAndView("Note/list","notes",notes);
    }
    @GetMapping("/create-note")
    public ModelAndView showCreateForm(){
        return new ModelAndView("Note/create","note",new Note());
    }
    @PostMapping("/create-note")
    public String CreateNote(@ModelAttribute Note note, RedirectAttributes redirect){
        noteService.save(note);
        redirect.addFlashAttribute("message","Add new note success");
        return "redirect:/notes";
    }
    @GetMapping("/view-note/{id}")
    public ModelAndView showViewForm(@PathVariable int id){
        return new ModelAndView("Note/view","note",noteService.findById(id));
    }
    @GetMapping("/delete-note/{id}")
    public String DeleteNote(@PathVariable int id,RedirectAttributes redirect){
        noteService.remove(id);
        redirect.addFlashAttribute("message","Delete note success");
        return "redirect:/notes";
    }
    @GetMapping("/edit-note/{id}")
    public ModelAndView showEditForm(@PathVariable int id){
        return new ModelAndView("Note/edit","note",noteService.findById(id));
    }
    @PostMapping("/edit-note")
    public String EditNote(@ModelAttribute Note note,RedirectAttributes redirect){
        noteService.save(note);
        redirect.addFlashAttribute("message","Edit note success");
        return "redirect:/notes";
    }
    @ModelAttribute("types")
    public Iterable<NoteType> ListType(Pageable pageable)   {
        return noteTypeService.findAll(pageable);
    }
}
