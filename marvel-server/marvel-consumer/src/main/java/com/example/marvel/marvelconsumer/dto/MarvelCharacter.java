package com.example.marvel.marvelconsumer.dto;

import lombok.Data;

import java.util.List;

@Data
public class MarvelCharacter {
    private int id;
    private String name;
    private String description;
    private String modified;
    private MarvelThumbnail thumbnail;
    private String resourceURI;
    private MarvelComics comics;
    private MarvelSeries series;
    private MarvelStories stories;
    private MarvelEvents events;
    private List<MarvelUrl> urls;

}
