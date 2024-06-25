package com.example.marvel.marvelconsumer.dto;

import lombok.Data;

import java.util.List;

@Data
public class MarvelEvents {
    private int available;
    private String collectionURI;
    private List<MarvelItem> items;
    private int returned;
}
