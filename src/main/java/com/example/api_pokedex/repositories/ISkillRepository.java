package com.example.api_pokedex.repositories;

import com.example.api_pokedex.entities.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISkillRepository extends JpaRepository <Skill, Long> {
}
