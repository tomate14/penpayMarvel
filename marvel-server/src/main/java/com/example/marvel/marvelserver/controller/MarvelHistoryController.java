package com.example.marvel.marvelserver.controller;

import com.example.marvel.marvelconsumer.dto.MarvelCharacter;
import com.example.marvel.marvelserver.entity.MarvelHistory;
import com.example.marvel.marvelserver.exceptions.ResourceNotFoundException;
import com.example.marvel.marvelserver.service.MarvelHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marvel/history")
@CrossOrigin(origins = "http://localhost:4200")
public class MarvelHistoryController {

    @Autowired
    private MarvelHistoryService historyService;

    @GetMapping()
    public List<MarvelHistory> getHistory() {
        return historyService.getHistory();
    }
}
