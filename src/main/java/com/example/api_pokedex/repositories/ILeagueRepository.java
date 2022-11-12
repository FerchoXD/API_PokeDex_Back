package com.example.api_pokedex.repositories;

import com.example.api_pokedex.entities.League;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILeagueRepository extends JpaRepository<League,Long> {
}
