package com.example.marvel.marvelserver.service;

import com.example.marvel.marvelserver.entity.MarvelHistory;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MarvelHistoryService {
    List<MarvelHistory> getHistory();
    MarvelHistory save(String service);

}
