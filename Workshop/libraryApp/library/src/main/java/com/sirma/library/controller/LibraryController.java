package com.sirma.library.controller;

import com.sirma.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LibraryController {
    @Autowired
    private LibraryService libraryService;

    @GetMapping("/books")
    public String viewBooks(Model model) {
        model.addAttribute("books", libraryService.getBooks());
        return "books";
    }
}
