package com.example.api.demo.service;

import com.example.api.demo.model.Pokemon;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PokemonService {
    private final String urlId = "https://pokeapi.co/api/v2/pokemon/{id}/";
    private final String url = "https://pokeapi.co/api/v2/pokemon/";

    @Autowired
    private RestTemplate restTemplate;

    //PokeAPI é somente para leitura(não permite alteração) :(

    //requisição get all
    public List<Map<String, Object>> pegarTodosPokemons() {
        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);
        Map<String, Object> result = response.getBody();
        List<Map<String, Object>> pokemons = (List<Map<String, Object>>) result.get("results");
        return pokemons;
    }

    //requisição get por id
    public Pokemon pegarPokemonPorId(int id) {
        ResponseEntity<Pokemon> response = restTemplate.getForEntity(urlId, Pokemon.class, id);
        return response.getBody();
    }

    // requisição post 
    public Pokemon criarPokemon(Pokemon pokemon) {
        ResponseEntity<Pokemon> response = restTemplate.postForEntity(url, pokemon, Pokemon.class);
        return response.getBody();
    }

    //requisição put
    public void atualizarPokemon(int id, Pokemon pokemon) {
        restTemplate.put(urlId, pokemon, id);
    }

    //requisição delete
    public void deletarPokemon(int id) {
        restTemplate.delete(urlId, id);
    }


}
