package com.example.marvel.marvelserver.controller;

import com.example.marvel.marvelconsumer.dto.MarvelCharacter;
import com.example.marvel.marvelconsumer.dto.MarvelData;
import com.example.marvel.marvelconsumer.service.MarvelService;
import com.example.marvel.marvelserver.exceptions.ResourceNotFoundException;
import com.example.marvel.marvelserver.service.MarvelHistoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class MarvelControllerTest {

    @Mock
    private MarvelService consumerService;

    @Mock
    private MarvelHistoryService historyService;

    @InjectMocks
    private MarvelController marvelController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(marvelController).build();
    }

    @Test
    public void testGetCharacters() throws Exception {
        MarvelData marvelData = new MarvelData();
        List<MarvelCharacter> characters = new ArrayList<>();
        characters.add(new MarvelCharacter());
        characters.add(new MarvelCharacter());
        characters.add(new MarvelCharacter());
        marvelData.setResults(characters);
        when(consumerService.getMarvelCharacters(anyInt())).thenReturn(marvelData);

        mockMvc.perform(get("/marvel/character?offset=0")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.results").exists());

        verify(historyService).save("getCharacters Page 0");
        verify(consumerService).getMarvelCharacters(0);
    }

    @Test
    public void testGetCharacter() throws Exception {
        MarvelCharacter marvelCharacter = new MarvelCharacter();
        marvelCharacter.setId(1010672);
        marvelCharacter.setName("Amora");

        when(consumerService.getMarvelCharacter(anyInt())).thenReturn(marvelCharacter);

        mockMvc.perform(get("/marvel/character/1010672")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1010672))
                .andExpect(jsonPath("$.name").value("Amora"));

        verify(historyService).save("getCharacter 1010672");
        verify(consumerService).getMarvelCharacter(1010672);
    }

    @Test
    public void testGetCharacterNotFound() throws Exception {
        when(consumerService.getMarvelCharacter(anyInt())).thenThrow(new ResourceNotFoundException("Character not found", null));

        mockMvc.perform(get("/marvel/character/9999")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

        verify(historyService).save("getCharacter 9999");
    }
}
