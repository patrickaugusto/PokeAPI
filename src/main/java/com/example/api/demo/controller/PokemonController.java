package com.example.api.demo.controller;

import com.example.api.demo.model.Pokemon;

import java.util.Optional;

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
    public String getAllData() {
        return pokemonService.getAllData();
    }

    /*@GetMapping("{id}/")
    public Optional<Pokemon> pegarPokemonPorId(@PathVariable Integer id) throws Exception {
        Optional<Pokemon> pokemon = pokemonService.pegarPokemonPorId(id);
        return pokemon;
    }

    @GetMapping("{name}/")
    public Optional<Pokemon> pegarPokemonPeloNome(@PathVariable String name) throws Exception {
        Optional<Pokemon> pokemon = pokemonService.pegarPokemonPorNome(name);
        return pokemon;
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
    }*/
    
}
