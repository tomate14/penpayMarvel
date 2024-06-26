package com.example.marvel.marvelserver.service.impl;

import com.example.marvel.marvelserver.entity.MarvelHistory;
import com.example.marvel.marvelserver.repository.MarvelHistoryRepository;
import com.example.marvel.marvelserver.service.MarvelHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MarvelHistoryServiceImpl implements MarvelHistoryService {
    @Autowired
    MarvelHistoryRepository marvelHistoryRepository;

    public List<MarvelHistory> getHistory() {
        return marvelHistoryRepository.findAll();
    }


    public MarvelHistory save(String service) {
        MarvelHistory entry = new MarvelHistory();
        entry.setDate(new Date());
        entry.setUrl(service);
        return marvelHistoryRepository.save(entry);
    }
}
