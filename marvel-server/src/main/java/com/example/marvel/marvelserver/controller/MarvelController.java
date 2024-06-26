package com.example.marvel.marvelserver.controller;

import com.example.marvel.marvelconsumer.dto.MarvelCharacter;
import com.example.marvel.marvelconsumer.dto.MarvelData;
import com.example.marvel.marvelconsumer.service.MarvelService;
import com.example.marvel.marvelserver.exceptions.ResourceNotFoundException;
import com.example.marvel.marvelserver.service.MarvelHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/marvel/character")
@CrossOrigin(origins = "http://localhost:4200")
public class MarvelController {

    @Autowired
    private MarvelService consumerService;

    @Autowired
    private MarvelHistoryService historyService;

    private final static int PAGE_LIMIT = 20;
    @GetMapping()
    public MarvelData getCharacters(@RequestParam(defaultValue = "0") int offset) {
        int pageNumber = offset / PAGE_LIMIT;
        String service = "getCharacters Page "+pageNumber;

        historyService.save(service);
        return consumerService.getMarvelCharacters(offset);
    }

    @GetMapping("/{idCharacter}")
    public MarvelCharacter getCharacter(@PathVariable("idCharacter") int idCharacter) {
        try {
            historyService.save("getCharacter "+idCharacter);
            return consumerService.getMarvelCharacter(idCharacter);
        } catch (Exception e) {
            throw new ResourceNotFoundException(e.getMessage(), e);
        }
    }
}
