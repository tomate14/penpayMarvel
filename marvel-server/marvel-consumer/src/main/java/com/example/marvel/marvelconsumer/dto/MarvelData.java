package com.example.marvel.marvelconsumer.dto;

import lombok.Data;

import java.util.List;

@Data
public class MarvelData {
    private int offset;
    private int limit;
    private int total;
    private int count;
    private List<MarvelCharacter> results;
}
