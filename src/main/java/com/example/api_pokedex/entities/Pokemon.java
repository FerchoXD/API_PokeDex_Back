package com.example.api_pokedex.entities;

import com.example.api_pokedex.entities.pivots.PokemonsSkill;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "pokemons")
@Getter @Setter
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true)
    private String name;

    private String species;

    private String type;

    private String image;

    @OneToOne(mappedBy = "pokemon")
    private Pokeball pokeball;

    @OneToMany(mappedBy = "pokemon")
    private List<PokemonsSkill> pokemonsSkills;
}
