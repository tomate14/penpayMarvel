package com.example.marvel.marvelconsumer.dto;

import lombok.Data;

import java.util.List;

@Data
public class MarvelStories {
    private int available;
    private String collectionURI;
    private List<MarvelStoryItem> items;
    private int returned;
}
