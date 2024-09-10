package com.example.api.demo.repository;

import com.example.api.demo.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon,Integer> {
    public Pokemon findByName(String name);
}
