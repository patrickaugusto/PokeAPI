package com.example.api.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pokemon {

    @Id
    private Integer id;
    private String name;
    private Integer height;
    private Integer weight;
    private Integer base_experience;

    // um pokemon pode ter varios tipos
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pokemon_id")
    private List<PokemonType> types;
}
