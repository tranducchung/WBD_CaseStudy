package com.codegym.cms.controller;

import com.codegym.cms.model.NoteType;
import com.codegym.cms.service.NoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class NoteTypeController {
    @Autowired
    private NoteTypeService noteTypeService;
    @GetMapping("/types")
    public ModelAndView showListType(@PageableDefault(value = 2) Pageable pageable){
        return new ModelAndView("Type/list","types",noteTypeService.findAll(pageable));
    }
    @GetMapping("/create-type")
    public ModelAndView showCreateForm(){
        return new ModelAndView("Type/create","type",new NoteType());
    }
    @PostMapping("/create-type")
    public String CreateType(@ModelAttribute NoteType noteType, RedirectAttributes redirect){
        noteTypeService.save(noteType);
        redirect.addFlashAttribute("message","Add new type success");
        return "redirect:/types";
    }
    @GetMapping("/edit-type/{id}")
    public ModelAndView showEditForm(@PathVariable int id){
        return new ModelAndView("Type/edit","type",noteTypeService.findById(id));
    }
    @PostMapping("/edit-type")
    public String EditType(@ModelAttribute NoteType noteType,RedirectAttributes redirect){
        noteTypeService.save(noteType);
        redirect.addFlashAttribute("message","Edit type success");
        return "redirect:/types";
    }
    @GetMapping("/delete-type/{id}")
    public String DeleteType(@PathVariable int id,RedirectAttributes redirect) {
        noteTypeService.remove(id);
        redirect.addFlashAttribute("message", "Delete type success");
        return "redirect:/types";
    }
}
