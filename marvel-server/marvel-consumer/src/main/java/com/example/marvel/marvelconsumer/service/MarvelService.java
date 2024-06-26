package com.example.marvel.marvelconsumer.service;

import com.example.marvel.marvelconsumer.dto.MarvelCharacter;
import com.example.marvel.marvelconsumer.dto.MarvelData;

public interface MarvelService {
    public MarvelData getMarvelCharacters(int offset);
    public MarvelCharacter getMarvelCharacter(int idCharacter) throws Exception;
}
