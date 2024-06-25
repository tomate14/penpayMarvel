package com.example.marvel.marvelconsumer.service;

import com.example.marvel.marvelconsumer.dto.MarvelCharacter;
import com.example.marvel.marvelconsumer.responses.MarvelApiResponse;

public interface MarvelService {
    public MarvelApiResponse getMarvelCharacters(int offset);
    public MarvelCharacter getMarvelCharacter(int idCharacter) throws Exception;
}
