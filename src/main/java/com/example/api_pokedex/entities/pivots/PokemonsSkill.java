package com.example.api_pokedex.entities.pivots;

import com.example.api_pokedex.entities.Pokemon;
import com.example.api_pokedex.entities.Skill;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "PokemonSkill")
@Getter
@Setter
public class PokemonsSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Pokemon pokemon;

    @ManyToOne
    private Skill skill;
}