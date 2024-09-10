package com.example.api.demo.service;

import com.example.api.demo.model.Pokemon;

import java.util.Optional;

import com.example.api.demo.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    private final String url = "https://pokeapi.co/api/v2/pokemon/";

    @Autowired
    private RestTemplate restTemplate;

    //requisição get all
    public String getAllData(){
        return restTemplate.getForObject(url, String.class);
    }

    //requisição get por id
    public Optional<Pokemon> pegarPokemonPorId(Integer id) throws Exception{
        Optional<Pokemon> pokemonOp = pokemonRepository.findById(id);
        if (pokemonOp.isEmpty()){
            throw new Exception();
        }
        return pokemonOp;
    }

    //requisição get por name
    public Optional<Pokemon> pegarPokemonPorNome(String name) throws Exception {
        Optional<Pokemon> pokemonOp = Optional.ofNullable(pokemonRepository.findByName(name));
        if (pokemonOp.isEmpty()){
            throw new Exception();
        }
        return pokemonOp;
    }

    // requisição post 
    public Pokemon criarPokemon(Pokemon pokemon) {
        ResponseEntity<Pokemon> response = restTemplate.postForEntity(url, pokemon, Pokemon.class);
        return response.getBody();
    }

    //requisição put
    public void atualizarPokemon(int id, Pokemon pokemon) {
        restTemplate.put(url, pokemon, id);
    }

    //requisição delete
    public void deletarPokemon(int id) {
        restTemplate.delete(url, id);
    }


}
