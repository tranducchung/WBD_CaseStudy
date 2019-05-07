package com.codegym.cms.controller;

import com.codegym.cms.model.Note;
import com.codegym.cms.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class iNotesController {
    @Autowired
    private NoteService noteService;
    @GetMapping("/notes")
    public ModelAndView showListNote(){
        return new ModelAndView("list","notes",noteService.findAll());
    }
    @GetMapping("/create-note")
    public ModelAndView showCreateForm(){
        return new ModelAndView("create","note",new Note());
    }
    @PostMapping("/create-note")
    public String CreateNote(@ModelAttribute Note note, RedirectAttributes redirect){
        noteService.save(note);
        redirect.addFlashAttribute("message","Add new note success");
        return "redirect:/notes";
    }
    @GetMapping("/view-note/{id}")
    public ModelAndView showViewForm(@PathVariable int id){
        return new ModelAndView("view","note",noteService.findById(id));
    }
    @GetMapping("/delete-note/{id}")
    public String DeleteNote(@PathVariable int id,RedirectAttributes redirect){
        noteService.remove(id);
        redirect.addFlashAttribute("message","Delete note success");
        return "redirect:/notes";
    }
    @GetMapping("/edit-note/{id}")
    public ModelAndView showEditForm(@PathVariable int id){
        return new ModelAndView("edit","note",noteService.findById(id));
    }
    @PostMapping("/edit-note")
    public String EditNote(@ModelAttribute Note note,RedirectAttributes redirect){
        noteService.save(note);
        redirect.addFlashAttribute("message","Edit note success");
        return "redirect:/notes";
    }
}
