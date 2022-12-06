package com.example.api_pokedex.repositories;

import com.example.api_pokedex.entities.Trainer;
import com.example.api_pokedex.entities.projections.TrainerProjections;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ITrainerRepository extends JpaRepository <Trainer, Long> {

    @Query(value ="SELECT * FROM trainers WHERE trainers.name = :nameTrainer ", nativeQuery = true)
    TrainerProjections Trainer(String nameTrainer);


    Optional<Trainer> findOneByEmail(String email);
}
