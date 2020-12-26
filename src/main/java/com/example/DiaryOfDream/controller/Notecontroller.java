package com.example.DiaryOfDream.controller;


import com.example.DiaryOfDream.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.DiaryOfDream.service.Noteservice;

import java.util.List;

@Controller
public class Notecontroller {

    private final Noteservice noteservice;
    @Autowired
    public Notecontroller(Noteservice noteservice) {
        this.noteservice = noteservice;
    }

    @GetMapping("/notes")
    public String findAll(Model model){
        List<Note> notes = noteservice.findAll();
        model.addAttribute("notes",notes);
        return "note-list";
    }
    @GetMapping("/note-create")
    public String createNoteForm(Note note){
        return "note-create";
    }
    @PostMapping("/note-create")
    public String createNote(Note note){
        noteservice.saveNote(note);
        return "redirect:/notes";
    }
    @GetMapping("note-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        noteservice.deleteById(id);
        return "redirect:/notes";
    }
    @GetMapping("note-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model){
        Note note =noteservice.findById(id);
        model.addAttribute("note",note);
        return "/note-update";
    }
    @PostMapping("/note-update")
    public String updateUser(Note note){
        noteservice.saveNote(note);
        return "redirect:/notes";
    }
}