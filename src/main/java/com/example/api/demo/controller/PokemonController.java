package com.example.api.demo.controller;

import com.example.api.demo.model.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.demo.service.PokemonService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("api/v1/")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @GetMapping("{id}/")
    public ResponseEntity<Pokemon> getPokemon(@PathVariable int id) {
        Pokemon pokemon = pokemonService.getPokemonById(id);
        return ResponseEntity.ok(pokemon);
    }
    
}
