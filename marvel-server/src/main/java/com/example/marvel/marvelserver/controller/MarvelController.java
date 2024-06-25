package com.example.marvel.marvelserver.controller;

import com.example.marvel.marvelconsumer.dto.MarvelCharacter;
import com.example.marvel.marvelconsumer.responses.MarvelApiResponse;
import com.example.marvel.marvelconsumer.service.MarvelService;
import com.example.marvel.marvelserver.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/marvel")
public class MarvelController {


    @Autowired
    private MarvelService consumerService;

    @GetMapping("/characters")
    public MarvelApiResponse getCharacters(@RequestParam(defaultValue = "0") int offset) {
        return consumerService.getMarvelCharacters(offset);
    }

    @GetMapping("/character/{idCharacter}")
    public MarvelCharacter getCharacter(@PathVariable("idCharacter") int idCharacter) {
        try {
            return consumerService.getMarvelCharacter(idCharacter);
        } catch (Exception e) {
            throw new ResourceNotFoundException(e.getMessage(), e);
        }
    }
}
