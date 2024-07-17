/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.literatura;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.literatura.models.Autor;
import com.mycompany.literatura.models.Libro;
import com.mycompany.literatura.models.dto.LibroDTO;
import com.mycompany.literatura.repositories.AutorRepository;
import com.mycompany.literatura.repositories.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;

@Service
public class GutendexService {
    private final GutendexClient client;
    private final ObjectMapper mapper;
    private final LibroRepository libroRepository;
    private final AutorRepository autorRepository;

    @Autowired
    public GutendexService(GutendexClient client, ObjectMapper mapper, LibroRepository libroRepository, AutorRepository autorRepository) {
        this.client = client;
        this.mapper = mapper;
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
    }

    public Libro searchAndSaveBook(String title) throws IOException, InterruptedException {
        String jsonResponse = client.searchBookByTitle(title);
        LibroDTO libroDTO = mapper.readValue(jsonResponse, LibroDTO.class);

        Autor autor = new Autor();
        autor.setNombre(libroDTO.getAuthors().get(0).getName());
        autor.setAnoNacimiento(libroDTO.getAuthors().get(0).getBirth_year());
        autor.setAnoFallecimiento(libroDTO.getAuthors().get(0).getDeath_year());

        Libro libro = new Libro();
        libro.setTitulo(libroDTO.getTitle());
        libro.setIdioma(libroDTO.getLanguages().get(0));
        libro.setDescargas(libroDTO.getDownloadCount());
        libro.setAutor(autor);

        return libroRepository.save(libro);
    }

    public List<Libro> getAllBooks() {
        return libroRepository.findAll();
    }

    public List<Libro> getBooksByLanguage(String idioma) {
        return libroRepository.findByIdioma(idioma);
    }

    public List<Autor> getAllAuthors() {
        return autorRepository.findAll();
    }

    public List<Autor> getAuthorsAliveInYear(int year) {
        return autorRepository.findByAnoNacimientoBeforeAndAnoFallecimientoAfter(year, year);
    }
}
