package com.example.api_pokedex.repositories;

import com.example.api_pokedex.entities.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPokemonRepository extends JpaRepository <Pokemon, Long> {
}
