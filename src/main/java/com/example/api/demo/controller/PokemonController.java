package com.example.api.demo.controller;

import com.example.api.demo.model.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.api.demo.service.PokemonService;


@RestController
@RequestMapping("api/v1/")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;


    @GetMapping("{id}/")
    public ResponseEntity<Pokemon> getPokemon(@PathVariable int id) {
        Pokemon pokemon = pokemonService.pegarPokemonPorId(id);
        return ResponseEntity.ok(pokemon);
    }

    @PostMapping
    public ResponseEntity<Pokemon> postPokemon(@RequestBody Pokemon pokemon) {
        Pokemon novoPokemon = pokemonService.criarPokemon(pokemon);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoPokemon);
    }

    @PutMapping("{id}/")
    public ResponseEntity<Void> putPokemon(@PathVariable int id, @RequestBody Pokemon pokemon) {
        pokemonService.atualizarPokemon(id, pokemon);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePokemon(@PathVariable int id) {
        pokemonService.deletarPokemon(id);
        return ResponseEntity.noContent().build();
    }
    // vai dar um erro 405. oq é isso? o gemini responde:
    //O erro "Method Not Allowed" (405) indica que o servidor web não permite que uma ação específica seja realizada em uma URL específica
    
}
