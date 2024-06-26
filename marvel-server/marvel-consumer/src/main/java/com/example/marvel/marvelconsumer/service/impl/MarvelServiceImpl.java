package com.example.marvel.marvelconsumer.service.impl;

import com.example.marvel.marvelconsumer.dto.MarvelCharacter;
import com.example.marvel.marvelconsumer.dto.MarvelData;
import com.example.marvel.marvelconsumer.responses.MarvelApiResponse;
import com.example.marvel.marvelconsumer.service.MarvelService;
import com.example.marvel.marvelconsumer.utils.Md5Hash;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
public class MarvelServiceImpl implements MarvelService {
    @Value("${marvel.api.publicKey}")
    private String publicKey;

    @Value("${marvel.api.privateKey}")
    private String privateKey;

    @Value("${marvel.api.baseUrl}")
    private String baseUrl;

    public MarvelData getMarvelCharacters(int offset) {
        String timestamp = "1";
        String hash = generateHash(timestamp);

        String url = String.format("%s?ts=%s&apikey=%s&hash=%s&offset=%d", baseUrl, timestamp, publicKey, hash, offset);
        RestTemplate restTemplate = new RestTemplate();
        MarvelApiResponse apiResponse = restTemplate.getForObject(url, MarvelApiResponse.class);
        return Objects.requireNonNull(apiResponse).getData();
    };

    public MarvelCharacter getMarvelCharacter(int idCharacter) throws Exception {

        try {
            String timestamp = "1";
            String hash = generateHash(timestamp);

            String url = String.format("%s/"+idCharacter+"?ts=%s&apikey=%s&hash=%s", baseUrl, timestamp, publicKey, hash);
            RestTemplate restTemplate = new RestTemplate();
            MarvelApiResponse apiResponse = restTemplate.getForObject(url, MarvelApiResponse.class);

            return Objects.requireNonNull(apiResponse).getData().getResults().get(0);

        } catch (Exception e) {
            throw new Exception("Invalid Character id "+idCharacter);
        }
    };

    private String generateHash(String timestamp) {
        String value = timestamp + privateKey + publicKey;
        return Md5Hash.md5Hex(value);
    }

}
