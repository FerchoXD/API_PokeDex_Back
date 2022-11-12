package com.example.api_pokedex.repositories;

import com.example.api_pokedex.entities.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITrainerRepository extends JpaRepository <Trainer, Long> {
}
