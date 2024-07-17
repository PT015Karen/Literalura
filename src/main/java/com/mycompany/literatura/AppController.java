/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.literatura;

import com.mycompany.literatura.models.Autor;
import com.mycompany.literatura.models.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AppController {
    private final GutendexService service;

    @Autowired
    public AppController(GutendexService service) {
        this.service = service;
    }

    @GetMapping("/search")
    public Libro searchBook(@RequestParam String title) throws IOException, InterruptedException {
        return (Libro) service.searchAndSaveBook(title);
    }

    @GetMapping("/books")
    public List<Libro> getAllBooks() {
        return service.getAllBooks();
    }

    @GetMapping("/books/language/{idioma}")
    public List<Libro> getBooksByLanguage(@PathVariable String idioma) {
        return service.getBooksByLanguage(idioma);
    }

    @GetMapping("/authors")
    public List<Autor> getAllAuthors() {
        return service.getAllAuthors();
    }

    @GetMapping("/authors/alive/{year}")
    public List<Autor> getAuthorsAliveInYear(@PathVariable int year) {
        return service.getAuthorsAliveInYear(year);
    }
}
