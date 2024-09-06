package com.example.api.demo.service;

import com.example.api.demo.model.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PokemonService {
    private final String url = "https://pokeapi.co/api/v2/pokemon/{id}/";

    @Autowired
    private RestTemplate restTemplate;

    public Pokemon getPokemonById(int id) {
        ResponseEntity<Pokemon> response = restTemplate.getForEntity(url, Pokemon.class, id);
        return response.getBody();
    }
}
