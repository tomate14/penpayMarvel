package com.example.marvel.marvelconsumer.responses;

import com.example.marvel.marvelconsumer.dto.MarvelData;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarvelApiResponse {
    private int code;
    private String status;
    private String copyright;
    private String attributionText;
    private String attributionHTML;
    private String etag;
    private MarvelData data;

}
