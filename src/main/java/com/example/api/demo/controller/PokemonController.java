package com.example.api.demo.controller;

import com.example.api.demo.model.Pokemon;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.api.demo.service.PokemonService;


@RestController
@RequestMapping("api/pokemon/")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> pegarTodosPokemons() {
        List<Map<String, Object>> pokemons = pokemonService.pegarTodosPokemons();
        return ResponseEntity.ok(pokemons);
    }

    @GetMapping("{id}/")
    public ResponseEntity<Pokemon> pegarPokemonPorId(@PathVariable int id) {
        Pokemon pokemon = pokemonService.pegarPokemonPorId(id);
        return ResponseEntity.ok(pokemon);
    }

    @PostMapping
    public ResponseEntity<Pokemon> inserirPokemon(@RequestBody Pokemon pokemon) {
        Pokemon novoPokemon = pokemonService.criarPokemon(pokemon);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoPokemon);
    }

    @PutMapping("{id}/")
    public ResponseEntity<Void> atualizarPokemonPorId(@PathVariable int id, @RequestBody Pokemon pokemon) {
        pokemonService.atualizarPokemon(id, pokemon);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPokemon(@PathVariable int id) {
        pokemonService.deletarPokemon(id);
        return ResponseEntity.noContent().build();
    }
    
}
