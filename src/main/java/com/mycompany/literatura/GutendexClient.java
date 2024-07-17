/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.literatura;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.literatura.models.dto.LibroDTO;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GutendexClient {

    private static final String BASE_URL = "https://gutendex.com/books/";

    public LibroDTO buscarLibroPorTitulo(String titulo) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(BASE_URL + "?search=" + titulo))
            .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(response.body(), LibroDTO.class);
    }

    String searchBookByTitle(String title) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
